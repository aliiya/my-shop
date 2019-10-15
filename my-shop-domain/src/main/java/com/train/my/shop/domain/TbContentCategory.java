package com.train.my.shop.domain;

import com.train.my.shop.commons.persistence.BaseTreeEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author: aliya
 * @Description:内容分类管理
 * @Data: Create in 2019/8/6 15:48
 * @Modify By:
 */
@Data
public class TbContentCategory extends BaseTreeEntity {
    @Length(min = 1,max = 20, message = "分类名称长度应介于1-20位之间")
    private String name;
    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    private Boolean isParent;
    private TbContentCategory parent;
}
