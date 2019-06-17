package com.ww.impl;

import com.ww.feign.RanClient;
import org.springframework.stereotype.Component;

/**
 * Implement RanClient.The fuse is triggered when the service fails
 * and the method of rewriting is performed here.
 *
 * @author: Sun
 * @create: 2019-04-26 10:53
 * @version: v1.0
 */
@Component
public class RanClientHystrixImpl implements RanClient {
    @Override
    public void getRanById(String id) {
        System.out.println("我是Feign中集成的Hystrix熔断器方法");
    }
}
