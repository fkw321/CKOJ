package com.ming.ckoj.controller.user;


import com.ming.ckoj.pojo.dto.Result;
import com.ming.ckoj.service.IUserProfileService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user/author")
public class UserProfileController {


    @Resource
    private IUserProfileService userProfileService;

    /**
     * 用户个人信息
     */
    @GetMapping("/profile")
    public Result me() {
        return userProfileService.me();
    }


}
