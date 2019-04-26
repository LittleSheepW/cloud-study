package com.ww.service.impl;

import com.ww.feign.RanClient;
import com.ww.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Client service implements.
 *
 * @author: Sun
 * @create: 2019-04-19 16:03
 * @version: v1.0
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Value("${app.service-url}")
    private String appServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RanClient ranClient;

    /**
     * 获取Ran(通过RestTemplate进行服务调用)
     */
    @Override
    // @HystrixCommand(fallbackMethod = "getBanByRestTemplateError")
    public void getRanByRestTemplate() {
        restTemplate.getForObject(appServiceUrl + "ran/get/{id}", String.class, "1");
    }

    /**
     * 获取Ran(通过Feign进行服务调用)
     */
    @Override
    public void getRanByFeign() {
        ranClient.getRanById("666");
    }


    /**
     * Hystrix熔断器，使用Hystrix有两种方式 (两种方式均要在启动类中加入@EnableHystrix注解)
     * 第一种是pom文件中加入Hystrix本身的依赖，然后再调用的方法上加入@HystrixCommand(fallbackMethod = "getBanByRestTemplateError")注解，fallbackMethod是断路是触发方法。
     *
     * 第二种是pom文件中加入Feign的依赖，然后再加入Hystrix的依赖并且在yml配置文件中设置feign.hystrix.enabled = true。
     * 重写FeignClient接口的方法，将重写的类交由Spring容器管理。FeignClient接口类注解@FeignClient中加入属性fallBack = 重写类.class即可。
     *
     * Feign集成Hystrix的时候遇到两个问题：
     *   1、加入@EnableHystrix的时候启动会报错，Feign默认集成了Hystrix，但是Hystrix的核心依赖并没有集成，所以还要在pom文件中加入Hystrix的依赖。
     *   2、在application.yml文件中设置feign.hystrix.enabled = true时没有提示。不用管他启动照样生效。
     */
    public void getBanByRestTemplateError() {
        System.out.println("我是普通Hystrix熔断器方法");
    }
}
