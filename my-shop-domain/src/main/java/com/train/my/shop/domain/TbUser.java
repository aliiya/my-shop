package com.train.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.train.my.shop.commons.persistence.BaseEntity;
import com.train.my.shop.commons.utils.RegexpUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: aliya
 * @Description:
 * @Data: Create in 2019/7/18 9:07
 * @Modify By:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TbUser extends BaseEntity {
    @Length(min = 6,max = 20, message = "姓名长度应介于6-20位之间")
    private String username;

    @JsonIgnore
    @Length(min = 6,max = 20, message = "密码长度应介于6-20位之间")
    private String password;

    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号码格式不正确")
    private String phone;

    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;
}
