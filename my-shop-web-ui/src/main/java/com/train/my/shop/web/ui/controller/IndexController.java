package com.train.my.shop.web.ui.controller;

import com.train.my.shop.web.ui.api.ContentsApi;
import com.train.my.shop.web.ui.dto.TbContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: aliya
 * @Description:首页
 * @Data: Create in 2019/8/15 14:43
 * @Modify By:
 */
@Controller
public class IndexController {

    /**
     * 跳转首页
     * @param model
     * @return
     */
    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        // 请求幻灯片
        requestContentsPPT(model);
        return "index";
    }

    /**
     * 请求幻灯片
     * @param model
     */
    private void requestContentsPPT(Model model) {
        List<TbContent> tbContents = ContentsApi.ppt();
        model.addAttribute("ppt", tbContents);
    }

}
