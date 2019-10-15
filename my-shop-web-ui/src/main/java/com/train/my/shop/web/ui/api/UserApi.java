package com.train.my.shop.web.ui.api;

import com.train.my.shop.commons.dto.BaseResult;
import com.train.my.shop.commons.utils.HttpClientUtils;
import com.train.my.shop.commons.utils.MapperUtils;
import com.train.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: aliya
 * @Description:会员接口
 * @Data: Create in 2019/8/16 17:21
 * @Modify By:
 */
public class UserApi {

    /**
     * 登陆
     * @param tbUser
     * @return
     */
    public static TbUser login(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", tbUser.getUsername()));
        params.add(new BasicNameValuePair("password", tbUser.getPassword()));

        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);
        return user;
    }
}
