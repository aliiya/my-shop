package com.train.my.shop.web.api.service.impl;

import com.train.my.shop.domain.TbContent;
import com.train.my.shop.domain.TbContentCategory;
import com.train.my.shop.web.api.dao.TbContentDao;
import com.train.my.shop.web.api.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/8/15 10:29
 * @Modify By:
 */
@Service
@Transactional(readOnly = true)
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    private TbContentDao tbContentDao;

    @Override
    public List<TbContent> selectByCategoryId(Long categoryid) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setId(categoryid);

        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(tbContentCategory);
        return tbContentDao.selectByCategoryId(tbContent);
    }
}
