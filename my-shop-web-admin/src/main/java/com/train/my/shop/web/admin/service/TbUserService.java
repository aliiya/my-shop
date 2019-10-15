package com.train.my.shop.web.admin.service;

import com.train.my.shop.commons.dto.PageInfo;
import com.train.my.shop.commons.persistence.BaseService;
import com.train.my.shop.domain.TbUser;
import com.train.my.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/7/18 9:21
 * @Modify By:
 */
public interface TbUserService extends BaseService<TbUser>{
    /**
     * 用户登陆
     * @param email
     * @param password
     * @return
     */
    TbUser login(String email, String password);

}
