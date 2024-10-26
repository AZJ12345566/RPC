package com.ajz.registry;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/10/21 12:45
 */

import com.ajz.spi.SpiLoader;

/**
 * 注册中心工厂
 */
public class RegistryFactory {
    static  {
        SpiLoader.load(Registry.class);
    }

    /**
     * 默认注册中心
     */
    public static final Registry DEFAULT_REGISTRY = new EtcdRegistry();

    /**
     * 获取实例
     * @param key
     * @return
     */
    public static Registry getInstance(String key) {
        return SpiLoader.getInstance(Registry.class, key);
    }
}
