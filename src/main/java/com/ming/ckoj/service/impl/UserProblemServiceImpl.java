package com.ming.ckoj.service.impl;

import com.ming.ckoj.pojo.dto.Result;
import com.ming.ckoj.service.IUserProblemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserProblemServiceImpl implements IUserProblemService {
    @Override
    public Result getUserAcceptedProblemInfo() {
        return Result.ok();
    }
}
