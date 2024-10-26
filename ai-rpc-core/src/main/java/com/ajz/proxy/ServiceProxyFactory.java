package com.ajz.proxy;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/7/17 15:25
 */

import com.ajz.RpcApplication;

import java.lang.reflect.Proxy;

/**
 * 服务代理工厂(用于创建代理对象)
 */
public class ServiceProxyFactory {
    /**
     * 根据服务获取代理对象
     * @param serviceClass
     * @return
     * @param <T>
     */
    public static <T> T getProxy(Class<T> serviceClass) {
        if (RpcApplication.getRpcConfig().isMock()) {
            return getMockProxy(serviceClass);
        }
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy()
        );
    }

    /**
     * 根据服务类获取 Mock 代理对象
     * @param serviceClass
     * @return
     * @param <T>
     */
    public static <T> T getMockProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new MockServiceProxy()
        );
    }
}
