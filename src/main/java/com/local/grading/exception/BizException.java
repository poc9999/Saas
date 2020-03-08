package com.local.grading.exception;

import com.local.grading.exception.enmu.ExceptionCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caishen
 * @version 1.0
 * @className BizException
 * @date 2020/3/8 12:21
 * 自分で書いたコードの各行を担当する
 * 通用异常
 **/
@Data
@NoArgsConstructor
public class BizException extends RuntimeException implements BaseException {
    /**
     * 统一错误码
     */
    public static final int ABNORAML_CODE = -1;
    /**
     * 编码
     */
    int code;
    /**
     * 异常信息
     */
    String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return message;
    }

    public BizException(int code,String message){
        super(message);
        this.code = code;
    }

    public BizException(String message){
        super(message);
        this.code = ABNORAML_CODE;
    }

    public static BizException build(ExceptionCode exceptionCode){
        return new BizException(exceptionCode.getCode(),exceptionCode.getMsg());
    }

}
