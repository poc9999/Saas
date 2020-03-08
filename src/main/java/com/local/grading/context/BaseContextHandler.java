package com.local.grading.context;

/**
 * @author caishen
 * @version 1.0
 * @className BaseContextHandler
 * @date 2020/3/8 12:01
 * 自分で書いたコードの各行を担当する
 * 线程隔离变量类
 **/
public class BaseContextHandler {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void setTenant(String tenantId) {
        THREAD_LOCAL.set(tenantId);
    }

    public static String getTenantId() {
        return THREAD_LOCAL.get();
    }

    public static void clear() {
        THREAD_LOCAL.remove();
    }

}
