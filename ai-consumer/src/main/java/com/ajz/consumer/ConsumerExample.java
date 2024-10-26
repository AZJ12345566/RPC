package com.ajz.consumer;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/10/19 09:56
 */

import com.ajz.common.model.User;
import com.ajz.common.service.UserService;
import com.ajz.config.RpcConfig;
import com.ajz.proxy.ServiceProxyFactory;
import com.ajz.utils.ConfigUtils;

/**
 * 简易服务消费者示例
 */
public class ConsumerExample {
    public static void main(String[] args) {
        //获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("小艾");
        //调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println("user == null");
        } else {
            System.out.println("user == null");
        }
        short number = userService.getNumber();
        System.out.println(number);
    }
}
