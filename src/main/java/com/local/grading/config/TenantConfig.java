package com.local.grading.config;

import com.local.grading.interceptor.TenantWebMvcConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author caishen
 * @version 1.0
 * @className TenantConfig
 * @date 2020/3/8 15:18
 * 自分で書いたコードの各行を担当する
 **/
@Configuration
public class TenantConfig {

    @Bean
    public TenantWebMvcConfigurer getTenantWebMvcConfigurer() {
        return new TenantWebMvcConfigurer();
    }
}
