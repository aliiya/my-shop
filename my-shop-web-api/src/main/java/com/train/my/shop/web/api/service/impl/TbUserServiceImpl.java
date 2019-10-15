package com.train.my.shop.web.api.service.impl;

import com.train.my.shop.domain.TbUser;
import com.train.my.shop.web.api.dao.TbUserDao;
import com.train.my.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Author: aliya
 * @Description:会员管理
 * @Data: Create in 2019/8/16 16:07
 * @Modify By:
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = tbUserDao.login(tbUser);
        if(user != null){
            //将明文密码加密
            String passwd = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());

            if(passwd.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }
}
