package com.train.my.shop.web.admin.service.Impl;

import com.train.my.shop.commons.validator.BeanValidator;
import com.train.my.shop.domain.TbUser;
import com.train.my.shop.commons.dto.BaseResult;
import com.train.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.train.my.shop.web.admin.dao.TbUserDao;
import com.train.my.shop.web.admin.service.TbUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/7/18 9:21
 * @Modify By:
 */
@Service
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser, TbUserDao> implements TbUserService {

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);

        if(validator != null){
            //校验不通过
            return BaseResult.fail(validator);
        }else{
            //校验通过
            tbUser.setUpdated(new Date());
            if(tbUser.getId() == null){
                //新增用户
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                dao.insert(tbUser);
            }else{
                //更新用户
                dao.update(tbUser);
            }
            return BaseResult.success("保存用户信息成功");
        }
    }

    @Override
    public TbUser login(String email, String password) {
        TbUser tbUser = dao.getByEmail(email);

        if(tbUser != null){
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if(md5Password.equals(tbUser.getPassword())){
                //用户验证完成，用户登陆
                return tbUser;
            }
        }
        return null;
    }

}
