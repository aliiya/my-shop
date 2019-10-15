package com.train.my.shop.web.api.web.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: aliya
 * @Description:内容数据传输对象
 * @Data: Create in 2019/8/15 11:02
 * @Modify By:
 */
@Data
public class TbContentDTO implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
}
