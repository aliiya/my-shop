package com.train.my.shop.web.admin.service.Impl;

import com.train.my.shop.commons.dto.BaseResult;
import com.train.my.shop.commons.persistence.BaseEntity;
import com.train.my.shop.commons.validator.BeanValidator;
import com.train.my.shop.domain.TbContentCategory;
import com.train.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import com.train.my.shop.web.admin.dao.TbContentCategoryDao;
import com.train.my.shop.web.admin.service.TbContentCategoryService;
import com.train.my.shop.web.admin.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: aliya
 * @Description:内容分类管理
 * @Data: Create in 2019/8/6 16:02
 * @Modify By:
 */
@Service
@Transactional(readOnly = true)
public class TbContentCategoryServiceImpl extends AbstractBaseTreeServiceImpl<TbContentCategory,TbContentCategoryDao> implements TbContentCategoryService{

    @Override
    @Transactional(readOnly = false)
    public BaseResult save(TbContentCategory entity) {
        String validator = BeanValidator.validator(entity);
        if(validator != null){
            return BaseResult.fail(validator);
        }else{
            TbContentCategory parent = entity.getParent();
            if(parent == null || parent.getId() == null){
                //0代表根目录，
                parent.setId(0L);
            }
            entity.setUpdated(new Date());
            if(entity.getId() == null){
                //新增
                entity.setCreated(new Date());
                entity.setIsParent(false);

                //判断当前新增的节点有没有父节点
                if(parent.getId() != 0L){
                    TbContentCategory currentCategoryParent = getById(parent.getId());
                    if(currentCategoryParent != null){
                        //更新父节点
                        currentCategoryParent.setIsParent(true);
                        dao.update(currentCategoryParent);
                    }
                }else{
                    //根目录一定是父级目录
                    entity.setIsParent(true);
                }
                dao.insert(entity);
            }else{
                //修改
                dao.update(entity);
            }
            return BaseResult.success("保存分类信息成功");
        }

    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        List<String> targetArray = new ArrayList<>();
        findAllChild(targetArray, id);

        String[] categoryIds = targetArray.toArray(new String[targetArray.size()]);

        // 删除类目及其子类目
        //tbContentService.delete(categoryIds);

        // 删除类目下所有内容
        //tbContentService.deleteByCategoryId(categoryIds);
    }

    /**
     * 查找出所有子节点
     *
     * @param targetList
     * @param parentId
     */
    private void findAllChild(List<String> targetList, Long parentId) {
        targetList.add(String.valueOf(parentId));

        List<TbContentCategory> tbContentCategories = selectByPid(parentId);
        for (TbContentCategory tbContentCategory : tbContentCategories) {
            findAllChild(targetList, tbContentCategory.getId());
        }
    }

}
