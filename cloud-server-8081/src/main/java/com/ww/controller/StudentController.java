package com.ww.controller;

import com.ww.pvo.StudentPvo;
import com.ww.service.StudentService;
import com.ww.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping(value = "/student")
@Slf4j
public class StudentController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private StudentService studentService;

    /**
     * Find all student.
     * @param:
     * @throws:
     * @return: java.util.List<com.com.ww.vo.StudentVo>
     * @author: Sun
     * @date: 2019-06-18 18:32
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<StudentVo> findAll() {
        log.info("[findAll] [无入参]");
        if (true) {
            throw new RuntimeException();
        }
        return studentService.findAll();
    }

    /**
     * Find student by Id.
     * @param: studentId
     * @throws:
     * @return: com.com.ww.vo.StudentVo
     * @author: Sun
     * @date: 2019-06-18 18:32
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StudentVo findById(@PathVariable(value = "id") Integer studentId) {
        log.info("[findById] [入参] [studentId:{}]", studentId);
        return studentService.findById(studentId);
    }

    /**
     * Save student.
     * @param: studentPvo
     * @throws:
     * @return: com.com.ww.vo.StudentVo
     * @author: Sun
     * @date: 2019-06-18 18:32
     */
    @RequestMapping(method = RequestMethod.POST)
    public StudentVo saveStudent(@RequestBody StudentPvo studentPvo) {
        log.info("[saveStudent] [入参] [studentPvo:{}]", studentPvo);
        return studentService.saveStudent(studentPvo);
    }

    /**
     * Update student.
     * @param: studentPvo
     * @throws:
     * @return: com.com.ww.vo.StudentVo
     * @author: Sun
     * @date: 2019-06-18 18:33
     */
    @RequestMapping(method = RequestMethod.PUT)
    public void updateStudent(@RequestBody StudentPvo studentPvo) {
        log.info("[updateStudent] [入参] [studentPvo:{}]", studentPvo);
        studentService.updateStudent(studentPvo);
    }

    /**
     * Delete Student.
     * @param: studentId
     * @throws:
     * @return: java.lang.Integer
     * @author: Sun
     * @date: 2019-06-18 18:33
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable(value = "id") Integer studentId) {
        log.info("[deleteStudent] [入参] [studentId:{}]", studentId);
        studentService.deleteStudent(studentId);
    }

    /**
     * 
     * @param: 
     * @throws: Eureka服务发现，提供此接口供使用放来了解我们的微服务信息
     * @return: java.lang.Object 
     * @author: Sun     
     * @date: 2019-06-18 18:33
     */ 
    @RequestMapping(value = "/discovery")
    public DiscoveryClient discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println("services list:" + services);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-SERVER");
        for (ServiceInstance instance : instances) {
            System.out.println("instance info:" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }


}
