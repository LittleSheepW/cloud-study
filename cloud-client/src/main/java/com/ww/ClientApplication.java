package com.ww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>@EnableEurekaClient<p/> 项目下所有被@RestController注解的对外服务接口将可通过注册-发布的方式对外提供服务。
 * <p>@EnableFeignClients</p> 扫描标记了@FeignClient的接口并创建实例bean。
 * <p>EnableHystrix</p> 开启Hystrix熔断器。
 *
 * @author: Sun
 * @create: 2019-04-16 15:39
 * @version: v1.0
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}

