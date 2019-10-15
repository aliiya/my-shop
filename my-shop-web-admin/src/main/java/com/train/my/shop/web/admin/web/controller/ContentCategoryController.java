package com.train.my.shop.web.admin.web.controller;

import com.train.my.shop.commons.dto.BaseResult;
import com.train.my.shop.domain.TbContentCategory;
import com.train.my.shop.web.admin.abstracts.AbstractBaseTreeController;
import com.train.my.shop.web.admin.service.TbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: aliya
 * @Description:内容分类管理
 * @Data: Create in 2019/8/6 16:02
 * @Modify By:
 */
@Controller
@RequestMapping(value = "content/category")
public class ContentCategoryController extends AbstractBaseTreeController<TbContentCategory, TbContentCategoryService> {
    /**
     *  表单模型初始化
     * @param id
     * @return
     */
    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id){
        TbContentCategory tbContentCategory = null;

        if(id != null){
            tbContentCategory = service.getById(id);
        }else{
            tbContentCategory = new TbContentCategory();
        }

        return tbContentCategory;
    }

    /**
     * 列表
     * @param model
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = service.selectAll();
        //排序
        sortList(sourceList, targetList, 0L);

        model.addAttribute("tbContentCategories", targetList);
        return "content_category_list";
    }

    /**
     * 跳转到内容表单页
     * @param tbContentCategory
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(TbContentCategory tbContentCategory){
        return "content_category_form";
    }

    /**
     * 保存内容信息
     * @param tbContentCategory
     * @param model
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbContentCategory tbContentCategory, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = service.save(tbContentCategory);

        if(baseResult.getStatus() == BaseResult.SUCCESS_STATUS){
            //保存内容信息成功
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/content/category/list";
        }else{
            //保存内容信息失败
            model.addAttribute("baseResult", baseResult);
            return "content_category_form";
        }
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            service.delete(Long.parseLong(ids));
            baseResult = BaseResult.success("删除分类及其子类及其全部内容成功");
        } else {
            baseResult = BaseResult.fail("删除分类失败");
        }

        return baseResult;
    }

    /**
     * 树形结构
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "tree/data", method = RequestMethod.POST)
    public List<TbContentCategory> treeData(Long id){
        if(id == null){
            id = 0L;
        }
        return service.selectByPid(id);
    }
}
