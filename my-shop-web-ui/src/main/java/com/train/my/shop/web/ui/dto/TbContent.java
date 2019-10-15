package com.train.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/8/15 16:51
 * @Modify By:
 */
@Data
public class TbContent implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
