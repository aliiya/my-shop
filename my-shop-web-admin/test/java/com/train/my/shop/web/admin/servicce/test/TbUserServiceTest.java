package com.train.my.shop.web.admin.servicce.test;

import com.train.my.shop.domain.TbUser;
import com.train.my.shop.web.admin.dao.TbUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/7/18 10:23
 * @Modify By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserDao tbUserDao;

    @Test
    public void testSelectAll() {
        List<TbUser> tbUsers = tbUserDao.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.toString());
        }
    }

    @Test
    public void testInsert() {
        TbUser tbUser = new TbUser();
        tbUser.setEmail("admin@train.com");
        tbUser.setPassword(DigestUtils.md5DigestAsHex("admin".getBytes()));
        tbUser.setPhone("15888888888");
        tbUser.setUsername("aliya");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());

        tbUserDao.insert(tbUser);
    }

    @Test
    public void testDelete() {
        TbUser tbUser = new TbUser();
        tbUser.setId(37L);

        tbUserDao.delete(tbUser.getId());
    }

    @Test
    public void testGetById() {
        TbUser tbUser = tbUserDao.getById(36L);
        System.out.println(tbUser.toString());
    }

    @Test
    public void testUpdate() {
        TbUser tbUser = tbUserDao.getById(36L);
        tbUser.setUsername("Lusifer");

        tbUserDao.update(tbUser);
    }

}
