package com.train.my.shop.commons.dto;

import java.io.Serializable;

/**
 * @Author: aliya
 * @Description: 自定义返回结果
 * @Data: Create in 2019/7/22 9:32
 * @Modify By:
 */
public class BaseResult implements Serializable {

    public static final int SUCCESS_STATUS = 200;
    public static final int FAIL_STATUS = 500;

    private int status;
    private String message;

    public static BaseResult success(){
        return createResult(SUCCESS_STATUS, "成功", null);
    }

    public static BaseResult success(String message){
        return createResult(SUCCESS_STATUS, message, null);
    }

    public static BaseResult success(String message, Object data){
        return createResult(SUCCESS_STATUS, message, data);
    }

    public static BaseResult fail(){
        return createResult(FAIL_STATUS, "失败", null);
    }

    public static BaseResult fail(String message){
        return createResult(FAIL_STATUS, message, null);
    }


    public static BaseResult fail(int status, String message){
        return createResult(status, message, null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //add  by aliya 2019-08-15  前端返回数据
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    //add  by aliya 2019-08-15  前端返回数据

    public static BaseResult createResult(int status, String message, Object data){
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return baseResult;
    }
}
