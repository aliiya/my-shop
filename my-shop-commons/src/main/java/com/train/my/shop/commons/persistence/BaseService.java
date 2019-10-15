package com.train.my.shop.commons.persistence;

import com.train.my.shop.commons.dto.BaseResult;
import com.train.my.shop.commons.dto.PageInfo;

import java.util.List;

/**
 * @Author: aliya
 * @Description:业务逻辑层基类
 * @Data: Create in 2019/8/12 11:43
 * @Modify By:
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 查询所有信息
     * @return
     */
    public List<T> selectAll();

    /**
     * 保存信息
     * @param entity
     */
    public BaseResult save(T entity);

    /**
     * 删除信息
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    T getById(long id);

    /**
     * 更新信息
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
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    PageInfo<T> page(int start, int length, int draw, T entity);

    /**
     * 总数据条数
     * @param entity
     * @return
     */
    int count(T entity);
}
