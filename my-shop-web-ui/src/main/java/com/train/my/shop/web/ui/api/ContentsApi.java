package com.train.my.shop.web.ui.api;

import com.train.my.shop.commons.utils.HttpClientUtils;
import com.train.my.shop.commons.utils.MapperUtils;
import com.train.my.shop.web.ui.dto.TbContent;

import java.util.List;

/**
 * @Author: aliya
 * @Description: 内容管理接口
 * @Data: Create in 2019/8/15 17:21
 * @Modify By:
 */
public class ContentsApi {

    /**
     * 请求幻灯片
     * @return
     */
    public static List<TbContent> ppt() {
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS_PPT);
        try {
            tbContents = MapperUtils.json2listByTree(result, "data", TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}
