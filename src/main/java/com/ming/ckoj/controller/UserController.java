package com.ming.ckoj.controller;

import com.ming.ckoj.dto.LoginFormDTO;
import com.ming.ckoj.dto.Result;
import com.ming.ckoj.service.IUserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/user")

public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 发送手机验证码
     */
    @PostMapping("/send-code")
    public Result sendCode(@RequestParam("phoneNumber") String phone) {
        log.info("发送验证码成功!");
        // TODO 发送短信验证码并保存验证码
        return userService.sendCode(phone);
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO loginFormDTO) {
        // TODO 实现登录功能
        log.info("实现登录功能");
        return  userService.login(loginFormDTO);
    }
}
