package com.ming.ckoj.service;

import com.ming.ckoj.dto.LoginFormDTO;
import com.ming.ckoj.dto.Result;

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
