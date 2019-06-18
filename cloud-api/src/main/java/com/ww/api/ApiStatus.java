package com.ww.api;

/**
 * API 请求返回的状态码
 */
public enum ApiStatus {

    /**
     * 操作成功
     */
    OK(0, "成功");

    private int code;
    private String msg;

    ApiStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
