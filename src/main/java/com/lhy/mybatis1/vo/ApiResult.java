package com.lhy.mybatis1.vo;

import java.io.Serializable;

public class ApiResult implements Serializable {

    private ApiResult() {
    }

    public static ApiResult newInstance() {
        return new ApiResult();
    }

    private String msg;
    private int code;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
