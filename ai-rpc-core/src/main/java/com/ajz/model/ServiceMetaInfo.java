package com.ajz.model;

/**
 * @author Collin Ai
 * @version 1.0
 * @date 2024/10/21 10:26
 */

import cn.hutool.core.util.StrUtil;
import lombok.Data;

/**
 * 服务元信息(注册信息)
 */
@Data
public class ServiceMetaInfo {

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 服务版本号
     */
    private String serviceVersion = "1.0";

    /**
     * 服务地址
     */
    private String serviceAddress;

    /**
     * 服务分组(暂未实现)
     */
    private String serviceGroup = "default";

    /**
     * 服务域名
     */
    private String serviceHost;

    /**
     * 服务端口
     */
    private Integer servicePort;

    /**
     * 用于获取服务键名
     * @return
     */
    public String getServiceKey() {
        //后续可扩展服务分组
        return String.format("%s:%s", serviceName, serviceVersion);
    }

    /**
     * 获取服务注册节点键名
     * @return
     */
    public String getServiceNodeKey() {
        return String.format("%s/%s", getServiceKey(), serviceAddress);
    }

    /**
     * 获取完整服务地址
     * @return
     */
    public String getServiceAddress() {
        if (!StrUtil.contains(serviceHost, "http")) {
            return String.format("http://%s:%s", serviceHost, servicePort);
        }
        return String.format("%s:%s", serviceHost, servicePort);
    }
}
