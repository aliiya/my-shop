package com.train.my.shop.commons.persistence;

import java.util.List;

/**
 * @Author: aliya
 * @Description:通用树形结构接口
 * @Data: Create in 2019/8/13 10:03
 * @Modify By:
 */
public interface BaseTreeDao<T extends BaseEntity> {
    /**
     * 查询所有数据
     * @return
     */
    public List<T> selectAll();

    /**
     * 新增数据
     * @param entity
     */
    public void insert(T entity);

    /**
     * 删除
     *
     * @param ids
     */
    void delete(String[] ids);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    T getById(long id);

    /**
     * 更新数据
     * @param entity
     */
    void update(T entity);

    /**
     * 根据父级节点查询所有子节点
     * @param pId
     * @return
     */
    List<T> selectByPid(Long pId);
}
