package com.train.my.shop.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: aliya
 * @Description: 会员注册
 * @Data: Create in 2019/8/16 17:33
 * @Modify By:
 */
@Controller
public class RegisterController {
    /**
     * 跳转注册页
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }
}
