package com.ming.ckoj.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.ckoj.dto.Result;
import com.ming.ckoj.entity.User;
import com.ming.ckoj.mapper.UserMapper;
import com.ming.ckoj.service.IUserService;
import com.ming.ckoj.utils.RegexUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.ming.ckoj.utils.RedisConstants.LOGIN_CODE_KEY;
import static com.ming.ckoj.utils.RedisConstants.LOGIN_CODE_TTL;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result sendCode(String phone) {
        if (RegexUtils.isPhoneInvalid(phone)) {
            return Result.fail("手机号格式错误");
        }
//        验证码
        String code = RandomUtil.randomNumbers(6);
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY + phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);

        log.info(code);
        return Result.ok();
    }

    @Override
    public void login() {


    }


}
