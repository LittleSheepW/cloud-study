package com.ww.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value = "ran")
public class RanController {

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
    

}
