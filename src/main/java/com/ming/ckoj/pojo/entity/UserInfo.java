package com.ming.ckoj.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_user_info")
@Builder
public class UserInfo implements Serializable {
    /**
     * 用户信息主键ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long id;

    private String nickName;

    private String icon;

    /**
     * 关注数
     */
    private int follow;
    
    /**
     * 粉丝数
     */
    private int fans;
    
    /**
     * 个人签名
     */
    private String signature;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}

