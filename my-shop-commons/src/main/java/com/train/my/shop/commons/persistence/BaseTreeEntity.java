package com.train.my.shop.commons.persistence;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/8/13 17:39
 * @Modify By:
 */
@Data
public abstract class BaseTreeEntity<T extends BaseEntity> extends BaseEntity implements Serializable {
    private T parent;
    private Boolean isParent;
}
