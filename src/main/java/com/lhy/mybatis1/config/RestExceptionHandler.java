package com.lhy.mybatis1.config;

import com.lhy.mybatis1.vo.ApiResult;
import com.lhy.mybatis1.vo.ApiResultGenerator;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus
    @ResponseBody
    public ApiResult runtimeExceptionHandler(Exception e) {
        e.printStackTrace();
        return ApiResultGenerator.errorResult(e.getMessage());
    }
}
