package com.local.grading.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author caishen
 * @version 1.0
 * @className DataSouceConfig
 * @date 2020/2/23 15:26
 * 自分で書いたコードの各行を担当する
 **/
@Configuration
public class DataSourceConfig {

    @Bean(name = DataSourcesDB.MASTER_DB)
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = DataSourcesDB.SLAVE_DB)
    @ConfigurationProperties(prefix = "spring.datasourceslave")
    public DataSource datasourceSlave(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }


}
