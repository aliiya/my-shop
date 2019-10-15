package com.train.my.shop.commons.persistence;

import com.train.my.shop.commons.dto.BaseResult;

import java.util.List;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/8/13 10:07
 * @Modify By:
 */
public interface BaseTreeService<T extends BaseEntity> {
    /**
     * 查询所有数据
     * @return
     */
    public List<T> selectAll();

    /**
     * 新增数据
     * @param entity
     */
    BaseResult save(T entity);

    /**
     * 删除数据
     * @param id
     */
    void delete(Long id);

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
