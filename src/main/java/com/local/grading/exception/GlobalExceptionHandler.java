package com.local.grading.exception;

import com.local.grading.exception.enmu.ExceptionCode;
import com.local.grading.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author caishen
 * @version 1.0
 * @className GlobalExceptionHandler
 * @date 2020/3/8 12:34
 * 自分で書いたコードの各行を担当する
 * 全局异常处理器
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    public R<Object> bizExceptionHandler(BizException bizException,HttpServletRequest request){
      log.error("BizException",bizException);
      return R.fail(ExceptionCode.TENANT_IS_NULL).setPath(request.getRequestURI());
    }

}
