package com.train.my.shop.commons.persistence;

import java.util.List;
import java.util.Map;

/**
 * @Author: aliya
 * @Description: 数据访问层的基类
 * @Data: Create in 2019/8/12 11:37
 * @Modify By:
 */
public interface BaseDao<T extends BaseEntity> {
    /**
     * 查询所有数据
     * @return
     */
    List<T> selectAll();

    /**
     * 新增数据
     * @param entity
     */
     void insert(T entity);

    /**
     * 删除
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
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params: start/记录开始数，length/每页记录数
     * @return
     */
    List<T> page(Map<String, Object> params);

    /**
     * 总数据条数
     * @param entity
     * @return
     */
    int count(T entity);
}
