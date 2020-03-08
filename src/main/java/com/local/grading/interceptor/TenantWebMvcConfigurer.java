package com.local.grading.interceptor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.spring.web.SpringfoxWebMvcConfiguration;

/**
 * @author caishen
 * @version 1.0
 * @className TenantWebMvcConfigurer
 * @date 2020/3/8 11:49
 * 自分で書いたコードの各行を担当する
 * 需要拦截的路径配置
 **/
@ConditionalOnClass(SpringfoxWebMvcConfiguration.class)
public class TenantWebMvcConfigurer implements WebMvcConfigurer {

    private static final String[] DEF_URLS = {
            "/v2/api-docs",
            "/v2/api-docs-ext",
            "/swagger-resources/**",
            "/webjars/**",
            "/csrf",
            "/swagger-ui.html**",
            "/doc.html**"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tenantContextHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns(DEF_URLS);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    protected TenantContextHandlerInterceptor tenantContextHandlerInterceptor() {
        return new TenantContextHandlerInterceptor();
    }
}
