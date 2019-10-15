package com.train.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: aliya
 * @Description: 会员
 * @Data: Create in 2019/8/16 17:21
 * @Modify By:
 */
@Data
public class TbUser implements Serializable{
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String verification;//验证码
}
