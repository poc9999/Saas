package com.local.grading.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.local.grading.context.BaseContextHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caishen
 * @version 1.0
 * @className MyBatisConfig
 * @date 2020/3/7 23:18
 * 自分で書いたコードの各行を担当する
 **/
@Configuration
@MapperScan(value = "com.local.grading.mapper")
public class MyBatisPlusConfig {

    /**
     * 多租户Id
     */
    private static final String TENANT_ID_COLUMN_NAME = "tenant_id";

    private static final List<String> FILTER_TABLE_LIST = new ArrayList<>();

    static {
        FILTER_TABLE_LIST.add("user");
    }

    /**
     * Mybatis Plus 多租户sql拦截器
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        List<ISqlParser> sqlParserList = new ArrayList<>();
        TenantSqlParser tenantSqlParser = new TenantSqlParser();

        tenantSqlParser.setTenantHandler(new TenantHandler() {

            @Override
            public Expression getTenantId(boolean where) {
                return new LongValue(BaseContextHandler.getTenantId());
            }

            @Override
            public String getTenantIdColumn() {
                return TENANT_ID_COLUMN_NAME;
            }

            @Override
            public boolean doTableFilter(String tableName) {
                return !FILTER_TABLE_LIST.stream().anyMatch(x->x.contains(tableName.toLowerCase()));
            }
        });
        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

}
