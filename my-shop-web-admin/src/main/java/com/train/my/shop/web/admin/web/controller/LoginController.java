package com.train.my.shop.web.admin.web.controller;

import com.train.my.shop.commons.constant.ConstantUtils;
import com.train.my.shop.domain.TbUser;
import com.train.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
/**
 * @Author: aliya
 * @Description: 登陆管理
 * @Data: Create in 2019/7/17 15:37
 * @Modify By:
 */
@Controller
public class LoginController{
    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

   /**
     * 登陆逻辑实现
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam String email, @RequestParam String password, HttpServletRequest httpServletRequest, Model model){
        TbUser tbUser = tbUserService.login(email, password);

        if(tbUser == null){
            //登陆失败
            model.addAttribute("message", "用户名或密码错误，请重新登陆");
            return login();
        }else{
            //登陆成功,将登陆信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "redirect:/main";
        }
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
        //清除session
        httpServletRequest.getSession().invalidate();
        return login();
    }
}

