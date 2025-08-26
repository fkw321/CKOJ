package com.ming.ckoj.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class UserInfoDTO {
    private Long id;
    private String nickName;
    private String icon;
    private int follow;
    private int fans;
    private String signature;

}
