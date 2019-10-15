package com.train.my.shop.web.admin.abstracts;

import com.train.my.shop.commons.persistence.BaseEntity;
import com.train.my.shop.commons.persistence.BaseTreeDao;
import com.train.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/8/13 10:22
 * @Modify By:
 */
public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity, D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    protected D dao;

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }

    /**
     * 删除
     * @param id
     */
    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        dao.delete(new String[]{String.valueOf(id)});
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public T getById(long id) {
        return dao.getById(id);
    }

    /**
     * 更新
     * @param entity
     */
    @Override
    @Transactional(readOnly = false)
    public void update(T entity) {
        dao.update(entity);
    }

    /**
     * 根据父节点查询
     * @param parentId
     * @return
     */
    @Override
    public List<T> selectByPid(Long parentId) {
        return dao.selectByPid(parentId);
    }

    /**
     * 新增
     * @param entity
     */
    public void insert(T entity) {
        dao.insert(entity);
    }
}
