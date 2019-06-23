package com.ww.controller;

import com.ww.api.ApiResult;
import com.ww.pvo.StudentPvo;
import com.ww.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Client Controller.
 *
 * @author: Sun
 * @create: 2019-04-16 16:09
 * @version: v1.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * 查询学生列表 (通过RestTemplate进行服务调用)
     * @param:
     * @throws:
     * @return: com.com.ww.api.ApiResult
     * @author: Sun
     * @date: 2019-06-18 18:25
     */
    @RequestMapping(value = "/student-rest-template", method = RequestMethod.GET)
    public ApiResult getStudentListByRestTemplate() {
        log.info("[getStudentListByRestTemplate] [无入参]");
        return ApiResult.success(clientService.getStudentListByRestTemplate());
    }

    /**
     * 通过id查询学生 (通过RestTemplate进行服务调用)
     * @param: id
     * @throws:
     * @return: com.com.ww.api.ApiResult
     * @author: Sun
     * @date: 2019-06-18 18:24
     */
    @RequestMapping(value = "/student-rest-template/{id}", method = RequestMethod.GET)
    public ApiResult getStudentByRestTemplate(@PathVariable(value = "id") Integer id) {
        log.info("[getStudentByRestTemplate] [入参] [id:{}]", id);
        return ApiResult.success(clientService.getStudentByRestTemplate(id));
    }

    /**
     * 保存学生 (通过RestTemplate进行服务调用)
     * @param: studentPvo
     * @throws:
     * @return: com.com.ww.api.ApiResult
     * @author: Sun
     * @date: 2019-06-18 18:25
     */
    @RequestMapping(value = "/student-rest-template", method = RequestMethod.POST)
    public ApiResult saveStudentByRestTemplate(@RequestBody StudentPvo studentPvo) {
        log.info("[saveStudentByRestTemplate] [入参] [StudentPvo:{}]", studentPvo);
        return ApiResult.success(clientService.saveStudentByRestTemplate(studentPvo));
    }

    /**
     * 更新学生 (通过RestTemplate进行服务调用)
     * @param: studentPvo
     * @throws:
     * @return: com.ww.api.ApiResult
     * @author: Sun
     * @date: 2019-06-23 14:47
     */
    @RequestMapping(value = "/student-rest-template", method = RequestMethod.PUT)
    public ApiResult updateStudentByRestTemplate(@RequestBody StudentPvo studentPvo) {
        log.info("[updateStudentByRestTemplate] [入参] [StudentPvo:{}]", studentPvo);
        clientService.updateStudentByRestTemplate(studentPvo);
        return ApiResult.success();
    }

    @RequestMapping(value = "/student-rest-template/{id}", method = RequestMethod.DELETE)
    public ApiResult deleteStudentByRestTemplate(@PathVariable(value = "id") Integer id) {
        log.info("[deleteStudentByRestTemplate] [入参] [studentId:{}]", id);
        clientService.deleteStudentByRestTemplate(id);
        return ApiResult.success();
    }


    /**
     * 查询学生列表 (通过Feign进行服务调用)
     * @param:
     * @throws:
     * @return: com.com.ww.api.ApiResult
     * @author: Sun
     * @date: 2019-06-18 17:32
     */
    @RequestMapping(value = "/student-feign", method = RequestMethod.GET)
    public ApiResult getStudentListByFeign() {
        log.info("[getStudentListByFeign] [无入参]");
        return ApiResult.success(clientService.getStudentListByFeign());
    }

    /**
     * 通过Feign进行服务调用
     * 1、Pom文件中引入Feign的依赖;
     * 2、在调用服务方启动类中加入@EnableFeignClients注解;
     * 3、然后写一个接口，接口上加入@FeignClient("xxx")注解，括号里面是调用的服务名称，在配置文件中进行配置;
     * 4、接口中方法加入@RequestMapping(value = "/student/{id}")，和被调用服务方请求保持一致;
     * 5、在需要调用的地方注入该接口，调用其方法即可。
     * @param: id
     * @throws:
     * @return: com.com.ww.api.ApiResult
     * @author: Sun
     * @date: 2019-06-18 18:25
     */
    @RequestMapping(value = "/student-feign/{id}", method = RequestMethod.GET)
    public ApiResult getStudentByFeign(@PathVariable(value = "id") Integer id) {
        log.info("[getStudentByFeign] [入参] [id:{}]", id);
        return ApiResult.success(clientService.getStudentByFeign(id));
    }

    /**
     * 保存学生 (通过Feign进行服务调用)
     * @param: studentPvo
     * @throws:
     * @return: com.com.ww.api.ApiResult
     * @author: Sun
     * @date: 2019-06-18 18:25
     */
    @RequestMapping(value = "/student-feign", method = RequestMethod.POST)
    public ApiResult saveStudentByFeign(@RequestBody StudentPvo studentPvo) {
        log.info("[saveStudentByFeign] [入参] [StudentPvo:{}]", studentPvo);
        return ApiResult.success(clientService.saveStudentByFeign(studentPvo));
    }

    /**
     * 修改学生 (通过Feign进行服务调用)
     * @param: studentPvo
     * @throws:
     * @return: com.ww.api.ApiResult
     * @author: Sun
     * @date: 2019-06-23 14:52
     */
    @RequestMapping(value = "/student-feign", method = RequestMethod.PUT)
    public ApiResult updateStudentByFeign(@RequestBody StudentPvo studentPvo) {
        log.info("[updateStudentByFeign] [入参] [StudentPvo:{}]", studentPvo);
        clientService.updateStudentByFeign(studentPvo);
        return ApiResult.success();
    }

    /**
     * 删除学生 (通过Feign进行服务调用)
     * @param: id
     * @throws:
     * @return: com.ww.api.ApiResult
     * @author: Sun
     * @date: 2019-06-23 14:52
     */
    @RequestMapping(value = "/student-feign/{id}", method = RequestMethod.DELETE)
    public ApiResult deleteStudentByFeign(@PathVariable(value = "id") Integer id) {
        log.info("[deleteStudentByFeign] [入参] [studentId:{}]", id);
        clientService.deleteStudentByFeign(id);
        return ApiResult.success();
    }



}
