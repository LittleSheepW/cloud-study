package com.ww.exception;


import com.ww.api.ApiStatus;

/**
 * 学生异常类.
 */
public class StudentException extends RuntimeException {
    /**
     * 状态码
     */
    private int code;
    public StudentException(int code, String message) {
        super(message);
        this.code = code;
    }

    public StudentException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public StudentException(ApiStatus apiStatus) {
        super(apiStatus.getMsg());
        this.code = apiStatus.getCode();
    }


    public int getCode() {
        return code;
    }
}
