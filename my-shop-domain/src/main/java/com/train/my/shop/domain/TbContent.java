package com.train.my.shop.domain;

import com.train.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author: aliya
 * @Description:内容管理
 * @Data: Create in 2019/8/7 11:58
 * @Modify By:
 */
@Data
public class TbContent extends BaseEntity {
    @Length(min = 1,max = 20, message = "标题长度应介于1-20位之间")
    private String title;

    @Length(min = 1,max = 20, message = "子标题长度应介于1-20位之间")
    private String subTitle;

    @Length(min = 1,max = 50, message = "标题描述长度应介于1-50位之间")
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;

    @Length(min = 1, message = "内容不能为空")
    private String content;

    @NotNull(message = "父级类目不能为空")
    private TbContentCategory tbContentCategory;
}
