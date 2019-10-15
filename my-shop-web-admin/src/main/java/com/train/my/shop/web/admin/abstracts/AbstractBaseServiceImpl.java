package com.train.my.shop.web.admin.abstracts;

import com.train.my.shop.commons.dto.PageInfo;
import com.train.my.shop.commons.persistence.BaseDao;
import com.train.my.shop.commons.persistence.BaseEntity;
import com.train.my.shop.commons.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: aliya
 * @Description:通用基础接口实现
 * @Data: Create in 2019/8/13 10:46
 * @Modify By:
 */
public abstract class AbstractBaseServiceImpl<T extends BaseEntity, D extends BaseDao<T>> implements BaseService<T> {
    @Autowired
    protected D dao;//子类也可以访问

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
    public void delete(Long id) {
        dao.delete(id);
    }

    /**
     * 根据id获取
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
    public void update(T entity) {
        dao.update(entity);
    }

    /**
     * 新增
     * @param entity
     */
    public void insert(T entity) {
        dao.insert(entity);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);
    }

    /**
     * 分页
     * @param start
     * @param length
     * @param draw
     * @param entity
     * @return
     */
    @Override
    public PageInfo<T> page(int start, int length, int draw, T entity) {
        int count = count(entity);

        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(dao.page(params));

        return pageInfo;
    }

    /**
     * 总计录数
     * @param entity
     * @return
     */
    @Override
    public int count(T entity) {
        return dao.count(entity);
    }
}
