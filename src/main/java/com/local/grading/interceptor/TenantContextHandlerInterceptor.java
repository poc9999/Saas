package com.local.grading.interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.local.grading.context.BaseContextHandler;
import com.local.grading.exception.BizException;
import com.local.grading.exception.enmu.ExceptionCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author caishen
 * @version 1.0
 * @className TenantContextHandlerInterceptor
 * @date 2020/3/8 11:50
 * 自分で書いたコードの各行を担当する
 * 租户上下文拦截器
 **/
@Slf4j
@NoArgsConstructor
public class TenantContextHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            log.info("未映射到方法,url:{}", request.getRequestURL());
            return preHandle(request, response, handler);
        }

        String tenantId = request.getParameter("tenantId");

        if (StringUtils.isBlank(tenantId)) {
            throw BizException.build(ExceptionCode.TENANT_IS_NULL);
        }
        BaseContextHandler.setTenant(tenantId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.clear();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
