package com.local.grading.interceptor;

/**
 * @author caishen
 * @version 1.0
 * @className DynamicTableNameParser
 * @date 2020/3/8 14:00
 * 自分で書いたコードの各行を担当する
 **/
//public class DynamicTableNameParser implements ISqlParser {
//
//    @Override
//    public SqlInfo parser(MetaObject metaObject, String sql) {
//
//        if(allowProcess(metaObject)){
//            String tenantCode = BaseContextHandler.getTenant();
//            if (StringUtils.isBlank(tenantCode)) {
//                return null;
//            }
//
//            MultiTenantInterceptor multiTenantInterceptor = new MultiTenantInterceptor();
//            // 想要 执行sql时， 切换到 切换到自己指定的库， 直接修改 setSchemaName
//            multiTenantInterceptor.setTenantId(BaseContextHandler.getTenant());
//            String parsedSql = multiTenantInterceptor.processSqlByInterceptor(sql);
//            return SqlInfo.newInstance().setSql(parsedSql);
//        }
//
//
//        return null;
//    }
//
//    /**
//     * 判断是否允许执行
//     * <p>例如：逻辑删除只解析 delete , update 操作</p>
//     *
//     * @param metaObject 元对象
//     * @return true
//     */
//    private boolean allowProcess(MetaObject metaObject) {
//        return true;
//    }
//}
