package com.ming.ckoj.controller.user;

import com.ming.ckoj.pojo.dto.Result;
import com.ming.ckoj.service.IUserProblemService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user/problem")
public class UserProblemController {

    @Resource
    private IUserProblemService userProblemService;
    /***
     * 用户题量
     * @return
     */
    @GetMapping("/question")
    public Result getUserAcceptedProblemInfo() {
        return userProblemService.getUserAcceptedProblemInfo();
    }
}
