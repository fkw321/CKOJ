package com.ming.ckoj.pojo.dto;

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
