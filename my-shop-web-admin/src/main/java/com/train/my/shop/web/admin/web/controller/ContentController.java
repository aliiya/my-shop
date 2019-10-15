package com.train.my.shop.web.admin.web.controller;

import com.train.my.shop.commons.dto.BaseResult;
import com.train.my.shop.commons.dto.PageInfo;
import com.train.my.shop.domain.TbContent;
import com.train.my.shop.web.admin.service.TbContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: aliya
 * @Description:内容管理
 * @Data: Create in 2019/8/7 12:07
 * @Modify By:
 */
@Controller
@RequestMapping(value = "/content")
public class ContentController {

    @Autowired
    private TbContentService tbContentService;

    /**
     *  表单模型初始化
     * @param id
     * @return
     */
    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent = null;

        if(id != null){
            tbContent = tbContentService.getById(id);
        }else{
            tbContent = new TbContent();
        }

        return tbContent;
    }

    /**
     * 跳转到内容列表页
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(){
        return "content_list";
    }

    /**
     * 跳转到内容表单页
     * @param model
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model){
        return "content_form";
    }

    /**
     * 保存内容信息
     * @param tbContent
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContent tbContent, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = tbContentService.save(tbContent);

        if(baseResult.getStatus() == BaseResult.SUCCESS_STATUS){
            //保存内容信息成功
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/list";
        }else{
            //保存内容信息失败
            model.addAttribute("baseResult", baseResult);
            return "content_form";
        }
    }

    /**
     * 批量删除内容信息
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if(StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            tbContentService.deleteMulti(idArray);
            baseResult = BaseResult.success("数据删除成功！");
        }else{
            baseResult = BaseResult.fail("数据删除失败！");
        }
        return baseResult;
    }

    /**
     * 分页查询
     * @param request
     * @param tbContent
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent){
        String strDraw  = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        //封装分页结果
        PageInfo<TbContent> pageInfo =  tbContentService.page(start, length, draw, tbContent);

        return pageInfo;
    }

    /**
     * 显示用户详情
     * @param tbContent
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(TbContent tbContent){
        return "content_detail";
    }
}
