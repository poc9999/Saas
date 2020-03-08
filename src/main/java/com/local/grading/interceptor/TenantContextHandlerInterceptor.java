package com.local.grading.interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.local.grading.context.BaseContextHandler;
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

        if(!(handler instanceof HandlerMethod)){
            log.info("未映射到方法,url:{}",request.getRequestURL());
            return preHandle(request,response,handler);
        }

        String tenant = request.getHeader("tenant");

        if(StringUtils.isBlank(tenant)){
            return false;
        }
        BaseContextHandler.setTenant(tenant);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
