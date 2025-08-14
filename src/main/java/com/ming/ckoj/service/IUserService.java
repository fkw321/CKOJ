package com.ming.ckoj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ming.ckoj.dto.LoginFormDTO;
import com.ming.ckoj.dto.Result;
import com.ming.ckoj.entity.User;

public interface IUserService extends IService<User> {


    Result sendCode(String phone);

    Result login(LoginFormDTO loginFormDTO);
}
