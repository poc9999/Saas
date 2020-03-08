package com.local.grading.interceptor;

import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author caishen
 * @version 1.0
 * @className TenantWebMvcConfigurer
 * @date 2020/3/8 11:49
 * 自分で書いたコードの各行を担当する
 * 需要拦截的路径配置
 **/
public class TenantWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tenantContextHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("**/login").order(10);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    protected TenantContextHandlerInterceptor tenantContextHandlerInterceptor(){
        return new TenantContextHandlerInterceptor();
    }
}
