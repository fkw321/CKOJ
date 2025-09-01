package com.ming.ckoj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ming.ckoj.dto.LoginFormDTO;
import com.ming.ckoj.dto.Result;
import com.ming.ckoj.pojo.entity.User;

public interface IUserService extends IService<User> {


    Result sendCode(String phone);

    Result login(LoginFormDTO loginFormDTO);

    Result me();

    Result logout(String token);

    Result info();
}