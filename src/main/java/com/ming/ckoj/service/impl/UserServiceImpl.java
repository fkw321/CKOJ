package com.ming.ckoj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.ckoj.dto.LoginFormDTO;
import com.ming.ckoj.dto.Result;
import com.ming.ckoj.dto.UserDTO;
import com.ming.ckoj.dto.UserInfoDTO;
import com.ming.ckoj.entity.User;
import com.ming.ckoj.entity.UserInfo;
import com.ming.ckoj.mapper.UserMapper;
import com.ming.ckoj.service.IUserInfoService;
import com.ming.ckoj.service.IUserService;
import com.ming.ckoj.utils.RegexUtils;
import com.ming.ckoj.utils.UserHolder;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.ming.ckoj.utils.RedisConstants.*;
import static com.ming.ckoj.utils.SystemConstants.USER_NIKE_NAME_PREFIX;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private IUserInfoService userInfoService;

    @Override
    public Result sendCode(String phone) {
        if (RegexUtils.isPhoneInvalid(phone)) {
            return Result.fail("手机号格式错误");
        }
//        验证码
        String code = RandomUtil.randomNumbers(6);
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY + phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);

        log.info(code);
        return Result.ok(code);
    }

    @Override
    public Result login(LoginFormDTO loginFormDTO) {
        String phone = loginFormDTO.getPhone();
        if (RegexUtils.isPhoneInvalid(phone)) {
            return Result.fail("手机号格式错误");
        }
//        验证码
        String code = loginFormDTO.getCode();
        String codeKey = LOGIN_CODE_KEY + phone;
        String cacheCode = stringRedisTemplate.opsForValue().get(codeKey);
        if (code == null || !code.equals(cacheCode)) {
            return Result.fail("验证码错误");
        }
//        查数据库是否有当前用户
        User user = query().eq("phone", phone).one();
        if (user == null) {
            user = createUserWithPhone(phone);
        }
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        Map<String, Object> userMap = BeanUtil.beanToMap(userDTO, new HashMap<>()
                , CopyOptions.create()
                        .setIgnoreNullValue(true)
                        .setFieldValueEditor((fieldName, fieldValue) -> fieldValue.toString()));
        String token = UUID.randomUUID().toString(true);
        String tokenKey = LOGIN_USER_KEY + token;
        stringRedisTemplate.opsForHash().putAll(tokenKey, userMap);
        stringRedisTemplate.expire(tokenKey, LOGIN_USER_TTL, TimeUnit.DAYS);
        log.info("生成的token："+token);
        return Result.ok(token);
    }

    @Override
    public Result me() {
//        userInfoService.getById(getCurrentUser().getId());
        UserDTO user = UserHolder.getUser();
        Long userId = user.getId();
        UserInfo userInfo = userInfoService.getById(userId);
        UserInfoDTO userInfoDTO = BeanUtil.copyProperties(userInfo, UserInfoDTO.class);
        return Result.ok(userInfoDTO);
    }

    @Override
    public void logout(String token) {
        String key = LOGIN_USER_KEY + token;
        stringRedisTemplate.delete(key);
    }

    public User createUserWithPhone(String phone) {
        User user = User.builder()
                .phone(phone)
                .nickName(USER_NIKE_NAME_PREFIX + RandomUtil.randomNumbers(10))
                .build();
        save(user);
        return user;
    }
}
