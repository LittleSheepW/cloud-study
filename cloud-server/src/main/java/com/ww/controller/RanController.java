package com.ww.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RanController Provide services.
 * Test the call between the service and the service through the
 * two methods of RestTemplate and Feign.
 *
 * @author: Sun
 * @create: 2019-04-16 15:52
 * @version: v1.0
 */
@RestController
@RequestMapping(value = "/ran")
public class RanController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 通过id获取ran
     *
     * @param: id
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-04-25 11:41
     */
    @RequestMapping(value = "get/{id}")
    public void getRanById(@PathVariable String id) {
        System.out.println("我是ranran" + id + "号");
    }

    /**
     * Eureka服务发现，提供此接口供使用放来了解我们的微服务信息
     * @param:
     * @throws:
     * @return: java.lang.Object
     * @author: Sun
     * @date: 2019-06-16 16:55
     */
    @RequestMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println("services list:" + services);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-SERVER");
        for (ServiceInstance instance : instances) {
            System.out.println("instance info:" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }


}
