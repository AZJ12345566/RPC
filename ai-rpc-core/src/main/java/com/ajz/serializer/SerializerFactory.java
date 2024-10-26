package com.ajz.serializer;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/10/20 09:42
 */

import com.ajz.spi.SpiLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 序列化工厂(用于获取序列化器对象)
 */
public class SerializerFactory {

    static {
        SpiLoader.load(Serializer.class);
    }

    /**
     * 默认序列化器
     */
    public static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    public static Serializer getInstance(String key) {
        return SpiLoader.getInstance(Serializer.class, key);
    }
}
