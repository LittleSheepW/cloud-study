package com.ww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * <p>@EnableHystrixDashboard<p/> 开启Hystrix仪表板 监控服务状态
 *
 * @author: Sun
 * @create: 2019-04-16 15:39
 * @version: v1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}

