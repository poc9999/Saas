//package com.local.grading.interceptor;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.session.RowBounds;
//
//import java.util.Properties;
//
///**
// * @author caishen
// * @version 1.0
// * @className MultiTenantInterceptor
// * @date 2020/3/7 22:59
// * 自分で書いたコードの各行を担当する
// * 多租户拦截器
// **/
//@Intercepts(value = {
//        @Signature(type = Executor.class,method = "query",args = {Object.class, MappedStatement.class, RowBounds.class})
//})
//@Slf4j
//public class MultiTenantInterceptor implements Interceptor {
//
//    private String tenantId;
//
//    public void setTenantId(String tenantId) {
//        this.tenantId = tenantId;
//    }
//
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//
//
//        log.info("002----{}",invocation.getArgs());
//
//        log.info("003----{}",invocation.getMethod());
//
//        log.info("004----{}",invocation.getTarget());
//
//        return invocation.proceed();
//    }
//
//    @Override
//    public Object plugin(Object target) {
//        return Plugin.wrap(target,this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//        log.info("001----设置属性");
//    }
//}
