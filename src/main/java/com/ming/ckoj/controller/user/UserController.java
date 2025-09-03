package com.ming.ckoj.controller.user;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user/user")

public class UserController {
/*
    @Resource
    private IUserService userService;

    *//**
     * 发送手机验证码
     *//*
    @PostMapping("/send-code")
    public Result sendCode(@RequestParam("phoneNumber") String phone) {
        log.info("发送验证码中");
        // TODO 发送短信验证码并保存验证码
        return userService.sendCode(phone);
    }

    *//**
     * 用户登录注册
     *
     * @param loginFormDTO
     * @return
     *//*
    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO loginFormDTO) {
        // TODO 实现登录功能
        log.info("实现登录功能");
        return userService.login(loginFormDTO);
    }

    *//**
     * 用户个人信息
     *//*
    @GetMapping("/profile")
    public Result me() {
        return userService.me();
    }

    *//***
     * 用户题量
     * @return
     *//*
    @GetMapping("/info")
    public Result info() {
        return userService.info();
    }

    *//**
     * 登出功能
     *
     * @return 无
     *//*
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        // 从请求头中获取token
        String token = request.getHeader("Authorization");
        log.info("token:" + token);
        if (token != null && !token.isEmpty()) {
            // 删除Redis中的用户信息
            return userService.logout(token);
        }
        return Result.ok();
    }*/


}
