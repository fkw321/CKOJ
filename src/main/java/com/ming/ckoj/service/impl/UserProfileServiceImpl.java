package com.ming.ckoj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ming.ckoj.dto.Result;
import com.ming.ckoj.dto.UserDTO;
import com.ming.ckoj.dto.UserInfoDTO;
import com.ming.ckoj.pojo.entity.User;
import com.ming.ckoj.pojo.entity.UserInfo;
import com.ming.ckoj.mapper.UserMapper;
import com.ming.ckoj.service.IUserInfoService;
import com.ming.ckoj.service.IUserProfileService;
import com.ming.ckoj.utils.UserHolder;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserProfileServiceImpl extends ServiceImpl<UserMapper, User> implements IUserProfileService {



    @Resource
    private IUserInfoService userInfoService;

    /**
     * 获取当前用户信息
     * @return
     */
    @Override
    public Result me() {
//        userInfoService.getById(getCurrentUser().getId());
        UserDTO user = UserHolder.getUser();
        Long userId = user.getId();
        UserInfo userInfo = userInfoService.getById(userId);
        UserInfoDTO userInfoDTO = BeanUtil.copyProperties(userInfo, UserInfoDTO.class);
        return Result.ok(userInfoDTO);
    }

    /**
     * 用户通过题目等信息
     *
     * @return
     */
    @Override
    public Result getUserAcceptedProblemInfo() {

        return Result.ok();
    }
}
