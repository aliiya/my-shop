package com.train.my.shop.web.api.dao;

import com.train.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/8/15 9:34
 * @Modify By:
 */
@Repository
public interface TbContentDao {

    /**
     * 根据内容类别id查询内容列表
     * @param tbContent
     * @return
     */
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
