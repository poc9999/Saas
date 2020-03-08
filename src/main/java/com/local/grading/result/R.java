package com.local.grading.result;

import com.local.grading.exception.enmu.ExceptionCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author caishen
 * @version 1.0
 * @className R
 * @date 2020/3/8 12:55
 * 自分で書いたコードの各行を担当する
 * 统一返回类
 **/
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class R<T> {

    /**
     * 返回code
     */
    private int code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;
    /**
     * 请求地址
     */
    private String path;

    private static final int SUCCESS = 200;

    private static final int FAIL = 500;

    /**
     * 带返回值的返回
     *
     * @param code
     * @param message
     * @param data
     */
    public R(int code, String message, T data) {
        this(code, message);
        this.data = data;
    }

    public R(int code, String message, T data, String path) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.path = path;
    }

    /**
     * 不带返回值的返回
     *
     * @param code
     * @param message
     */
    public R(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <S> R<S> success(S data) {
        return new R<>(SUCCESS, "ok", data);
    }

    public static R success() {
        return new R(SUCCESS, "ok");
    }

    public static <E>R<E> fail() {
        return new R<>(FAIL, "fail");
    }

    public static <E>R<E> fail(ExceptionCode exceptionCode){
        return new R<>(exceptionCode.getCode(),exceptionCode.getMsg());
    }

}
