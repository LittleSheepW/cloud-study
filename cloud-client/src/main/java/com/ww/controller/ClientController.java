package com.ww.controller;

import com.ww.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Client Controller.
 *
 * @author: Sun
 * @create: 2019-04-16 16:09
 * @version: v1.0
 */
@RestController
@RequestMapping(value = "client")
public class ClientController {

    @Autowired
    private ClientService clientService;


    /**
     * 通过RestTemplate进行服务调用
     *
     * @param:
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-04-25 11:46
     */
    @RequestMapping(value = "getByRest")
    public void getByRest() {
        clientService.getRanByRestTemplate();
    }

    /**
     * 通过Feign进行服务调用
     * 1、Pom文件中引入Feign的依赖;
     * 2、在调用服务方启动类中加入@EnableFeignClients注解;
     * 3、然后写一个接口，接口上加入@FeignClient("xxx")注解，括号里面是调用的服务名称，在配置文件中进行配置;
     * 4、接口中方法加入@RequestMapping(value = "/ran/get/{id}")，和被调用服务方请求保持一致;
     * 5、在需要调用的地方注入该接口，调用其方法即可。
     * @param:
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-04-25 11:39
     */
    @RequestMapping(value = "getByFeign")
    public void getByFeign() {
        clientService.getRanByFeign();
    }

}
