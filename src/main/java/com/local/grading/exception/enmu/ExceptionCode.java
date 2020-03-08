package com.local.grading.exception.enmu;

import com.local.grading.exception.BaseException;

/**
 * @author caishen
 * @version 1.0
 * @className ExceptionCode
 * @date 2020/3/8 12:41
 * 自分で書いたコードの各行を担当する
 **/
public enum ExceptionCode implements BaseException {
    TENANT_IS_NULL(1, "租户信息不存在");

    private int code;

    private String message;

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return message;
    }

    public ExceptionCode build(String msg, Object... param) {
        this.message = String.format(msg, param);
        return this;
    }
}
