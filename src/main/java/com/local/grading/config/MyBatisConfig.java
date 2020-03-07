package com.local.grading.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author caishen
 * @version 1.0
 * @className MyBatisConfig
 * @date 2020/3/7 23:18
 * 自分で書いたコードの各行を担当する
 **/
@Configuration
@MapperScan(value = "com.local.grading.mapper")
public class MyBatisConfig {
}
