package com.train.my.shop.web.api.web.controller.v1;

import com.train.my.shop.commons.dto.BaseResult;
import com.train.my.shop.domain.TbUser;
import com.train.my.shop.web.api.service.TbUserService;
import com.train.my.shop.web.api.web.dto.TbUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: aliya
 * @Description:会员管理
 * @Data: Create in 2019/8/16 16:34
 * @Modify By:
 */
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseResult login(TbUser tbUser){
        TbUser user = tbUserService.login(tbUser);
        if(user == null){
            return BaseResult.fail("账号或密码有误");
        }else{
            TbUserDTO dto = new TbUserDTO();
            BeanUtils.copyProperties(user, dto);
            return BaseResult.success("成功", dto);
        }
    }
}
