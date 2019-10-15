package com.train.my.shop.web.admin.service.Impl;

import com.train.my.shop.commons.dto.BaseResult;
import com.train.my.shop.commons.validator.BeanValidator;
import com.train.my.shop.domain.TbContent;
import com.train.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.train.my.shop.web.admin.dao.TbContentDao;
import com.train.my.shop.web.admin.service.TbContentService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: aliya
 * @Description:内容管理
 * @Data: Create in 2019/8/7 12:06
 * @Modify By:
 */
@Service
public class TbContentServiceImpl extends AbstractBaseServiceImpl<TbContent, TbContentDao> implements TbContentService {

    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);

        if(validator != null){
            //校验不通过
            return BaseResult.fail(validator);
        }else {
            //校验通过
            tbContent.setUpdated(new Date());
            if (tbContent.getId() == null) {
                //新增用户
                tbContent.setCreated(new Date());
                dao.insert(tbContent);
            } else {
                //更新用户
                dao.update(tbContent);
            }
            return BaseResult.success("保存内容信息成功");
        }
    }

}
