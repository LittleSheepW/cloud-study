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
}
