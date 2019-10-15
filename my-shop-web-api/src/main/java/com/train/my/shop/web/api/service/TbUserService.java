package com.train.my.shop.web.api.service;

import com.train.my.shop.domain.TbUser;

/**
 * @Author: aliya
 * @Description:会员管理
 * @Data: Create in 2019/8/16 16:06
 * @Modify By:
 */
public interface TbUserService {
    /**
     * 登陆
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);
}
