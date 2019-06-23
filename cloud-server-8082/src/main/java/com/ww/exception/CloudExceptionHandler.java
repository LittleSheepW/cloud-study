package com.ww.exception;

import com.ww.api.ApiResult;
import com.ww.api.ApiStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 */
@ControllerAdvice
@Slf4j
public class CloudExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResult handleException(Exception e) {
        log.error("[handleException]", e);
        return ApiResult.fail(ApiStatus.RUNTIME_ERROR.getCode(), (StringUtils.isEmpty(e.getMessage()) ? "操作异常" : e.getMessage()));
    }


    @ExceptionHandler(value = StudentException.class)
    @ResponseBody
    public ApiResult handleException(StudentException e) {
        log.error("[handleException]", e);
        return ApiResult.fail(e.getCode(), e.getMessage());
    }


}
