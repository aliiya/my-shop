package com.train.my.shop.web.admin.dao;

import com.train.my.shop.commons.persistence.BaseDao;
import com.train.my.shop.commons.persistence.BaseTreeDao;
import com.train.my.shop.domain.TbContentCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/8/6 16:00
 * @Modify By:
 */
@Repository
public interface TbContentCategoryDao extends BaseTreeDao<TbContentCategory> {
}
