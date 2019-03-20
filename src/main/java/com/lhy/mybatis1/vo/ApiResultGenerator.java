package com.lhy.mybatis1.vo;

public class ApiResultGenerator {

    public static ApiResult result(int code,String msg,Object data){
        ApiResult apiResult = ApiResult.newInstance();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public static ApiResult successResult(Object data){
        return result(1,"",data);
    }

    public static ApiResult errorResult(String msg){
        return result(0,msg,null);
    }
}
