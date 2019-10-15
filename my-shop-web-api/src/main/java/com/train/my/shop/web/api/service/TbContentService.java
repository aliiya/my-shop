package com.train.my.shop.web.api.service;

import com.train.my.shop.domain.TbContent;

import java.util.List;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/8/15 10:28
 * @Modify By:
 */
public interface TbContentService {
    /**
     * 根据内容类别id查询内容列表
     * @param categoryid
     * @return
     */
    List<TbContent> selectByCategoryId(Long categoryid);
}
