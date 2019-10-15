package com.train.my.shop.web.ui.controller;

import com.google.code.kaptcha.Constants;
import com.train.my.shop.commons.dto.BaseResult;
import com.train.my.shop.commons.utils.EmailSendUtils;
import com.train.my.shop.web.ui.api.UserApi;
import com.train.my.shop.web.ui.constant.SystemConstans;
import com.train.my.shop.web.ui.dto.TbUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: aliya
 * @Description:会员登陆管理
 * @Data: Create in 2019/8/16 17:32
 * @Modify By:
 */
@Controller
public class LoginController {
    @Autowired
    private EmailSendUtils emailSendUtils;

    /**
     * 跳转登陆页
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     *  用户登陆
     * @param tbUser
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(TbUser tbUser, Model model, HttpServletRequest request) throws Exception {
        //验证码校验失败
        if(!checkVerfication(tbUser, request)){
            model.addAttribute("baseResult", BaseResult.fail("验证码有误，请重新输入！"));
            return "login";
        }
        TbUser user = UserApi.login(tbUser);
        if(user == null){
            //登陆失败
            model.addAttribute("baseResult",BaseResult.fail("用户名或密码错误，请重新输入！"));
            return "login";
        }else{
            emailSendUtils.send("用户登录", String.format("用户 【%s】 登录 MyShop", user.getUsername()), "1078126514@qq.com");
            //登陆成功，将会员信息放入session中，重定向到首页
            request.getSession().setAttribute(SystemConstans.SESSION_USER_KEY, user);
            return "redirect:/index";
        }
    }

    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        //清除session
        request.getSession().invalidate();
        return "redirect:/index";
    }

    /**
     * 检查验证码
     * @param tbUser
     * @param request
     * @return
     */
    private boolean checkVerfication(TbUser tbUser, HttpServletRequest request){
        String verfication = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(StringUtils.equals(verfication, tbUser.getVerification())){
            return true;
        }else{
            return false;
        }
    }
}
