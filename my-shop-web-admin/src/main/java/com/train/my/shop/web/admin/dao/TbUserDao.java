package com.train.my.shop.web.admin.dao;

import com.train.my.shop.commons.persistence.BaseDao;
import com.train.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/7/18 9:16
 * @Modify By:
 */
@Repository
public interface TbUserDao extends BaseDao<TbUser>{
    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
