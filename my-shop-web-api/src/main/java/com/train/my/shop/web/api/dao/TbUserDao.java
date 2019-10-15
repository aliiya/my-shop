package com.train.my.shop.web.api.dao;

import com.train.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * @Author: aliya
 * @Description:会员管理
 * @Data: Create in 2019/8/16 16:01
 * @Modify By:
 */
@Repository
public interface TbUserDao {

    /**
     * 登陆
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
