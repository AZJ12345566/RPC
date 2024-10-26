package com.ajz.provider;

import com.ajz.RpcApplication;
import com.ajz.common.service.UserService;
import com.ajz.registry.LocalRegistry;
import com.ajz.server.VertxHttpServer;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/10/19 10:01
 */

/**
 * 能够根据配置动态的在不同端口启动web服务
 */
public class ProviderExample {
    public static void main(String[] args) {
        //RPC 框架初始化
        RpcApplication.init();

        //注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        //启动web服务
        VertxHttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
