package com.ming.ckoj.controller.user;


import com.ming.ckoj.dto.LoginFormDTO;
import com.ming.ckoj.dto.Result;
import com.ming.ckoj.service.ILoginService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user/login")
public class LoginController {
    @Resource
    private ILoginService loginService;
    /**
     * 发送手机验证码
     */
    @PostMapping("/send-code")
    public Result sendCode(@RequestParam("phoneNumber") String phone) {
        log.info("发送验证码中");
        // TODO 发送短信验证码并保存验证码
        return loginService.sendCode(phone);
    }

    /**
     * 用户登录注册
     *
     * @param loginFormDTO
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginFormDTO loginFormDTO) {
        // TODO 实现登录功能
        log.info("实现登录功能");
        return loginService.login(loginFormDTO);
    }

    /**
     * 登出功能
     *
     * @return 无
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        // 从请求头中获取token
        String token = request.getHeader("Authorization");
        log.info("token:" + token);
        if (token != null && !token.isEmpty()) {
            // 删除Redis中的用户信息
            return loginService.logout(token);
        }
        return Result.ok();
    }
}
