package com.ming.ckoj.service;

import com.ming.ckoj.pojo.dto.Result;
import com.ming.ckoj.pojo.dto.LoginFormDTO;

public interface ILoginService {
    /**
     * 发送验证码
     * @param phone
     * @return
     */
    Result sendCode(String phone);

    /**
     * 登录
     *
     * @param loginFormDTO
     * @return
     */
    Result login(LoginFormDTO loginFormDTO);

    /**
     * 当前账号登出
     *
     * @param token
     * @return
     */
    Result logout(String token);

}
