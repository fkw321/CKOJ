package com.ming.ckoj.controller;

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
    public Result sendCode(@RequestParam("phone") String phone) {
        // TODO 发送短信验证码并保存验证码
        return userService.sendCode(phone);
    }

    @PostMapping("/login")
    public Result login() {
        // TODO 实现登录功能
        log.info("实现登录功能");
        return Result.ok();
    }
}
