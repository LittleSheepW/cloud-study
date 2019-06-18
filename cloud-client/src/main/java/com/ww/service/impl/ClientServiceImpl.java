package com.ww.service.impl;

import com.ww.feign.ClientFeign;
import com.ww.pvo.StudentPvo;
import com.ww.service.ClientService;
import com.ww.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    private ClientFeign clientFeign;

    @Override
    public StudentVo getStudentByRestTemplate(Integer id) {
        return restTemplate.getForObject(appServiceUrl + "/student/{1}", StudentVo.class, id);
    }

    @Override
    public StudentVo saveStudentByRestTemplate(StudentPvo studentPvo) {
        return restTemplate.postForObject(appServiceUrl + "/student", studentPvo, StudentVo.class);
    }

    @Override
    public List<StudentVo> getStudentListByRestTemplate() {
        return restTemplate.getForObject(appServiceUrl + "/student", List.class);
    }

    @Override
    public StudentVo getStudentByFeign(Integer id) {
        return clientFeign.getStudentById(id);
    }

    @Override
    public StudentVo saveStudentByFeign(StudentPvo student) {
        return clientFeign.saveStudent(student);
    }

    @Override
    public List<StudentVo> getStudentListByFeign() {
        return clientFeign.getStudentList();
    }

    /**
     * 单个熔断方法
     */
    public void getStudentByRestTemplateError() {
        System.out.println("我是普通Hystrix熔断器方法");
    }
}
