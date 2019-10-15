package com.train.my.shop.web.admin.web.controller;

import com.train.my.shop.commons.dto.PageInfo;
import com.train.my.shop.domain.TbUser;
import com.train.my.shop.commons.dto.BaseResult;
import com.train.my.shop.web.admin.abstracts.AbstractBaseController;
import com.train.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @Author: aliya
 * @Description: 用户管理
 * @Data: Create in 2019/7/18 15:37
 * @Modify By:
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends AbstractBaseController<TbUser, TbUserService>{

    /**
     *  表单模型初始化
     * @param id
     * @return
     */
    @ModelAttribute
    public TbUser getTbUser(Long id){
        TbUser tbUser = null;

        if(id != null){
            tbUser = service.getById(id);
        }else{
            tbUser = new TbUser();
        }

        return tbUser;
    }

    /**
     * 跳转到用户列表页
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(){
        return "user_list";
    }

    /**
     * 跳转到用户表单页
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(){
        return "user_form";
    }

    /**
     * 保存用户信息
     * @param tbUser
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = service.save(tbUser);

        if(baseResult.getStatus() == BaseResult.SUCCESS_STATUS){
            //保存用户信息成功
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        }else{
            //保存用户信息失败
            model.addAttribute("baseResult", baseResult);
            return "user_form";
        }
    }

    /**
     * 批量删除用户信息
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            service.deleteMulti(idArray);
            baseResult = BaseResult.success("数据删除成功！");
        }else{
            baseResult = BaseResult.fail("数据删除失败！");
        }
        return baseResult;
    }

    /**
     * 显示用户详情
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(TbUser tbUser){
        return "user_detail";
    }
}
