package com.ww.hystrix.impl;

import com.ww.feign.ClientFeign;
import com.ww.pvo.StudentPvo;
import com.ww.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement ClientFeign.The fuse is triggered when the service fails
 * and the method of rewriting is performed here.
 *
 * @author: Sun
 * @create: 2019-04-26 10:53
 * @version: v1.0
 */
@Component
@Slf4j
public class ClientFeignHystrixImpl implements ClientFeign {

    @Override
    public StudentVo getStudentById(Integer id) {
        log.warn("[getStudentById:{}] ", "触发熔断方法");
        return null;
    }

    @Override
    public StudentVo saveStudent(StudentPvo studentPvo) {
        log.warn("[saveStudent:{}] ", "触发熔断方法");
        return null;
    }

    @Override
    public List<StudentVo> getStudentList() {
        log.warn("[getStudentList:{}] ", "触发熔断方法");
        return new ArrayList<>();
    }

    @Override
    public void updateStudent(StudentPvo student) {
        log.warn("[updateStudent:{}] ", "触发熔断方法");
    }

    @Override
    public void deleteStudent(Integer id) {
        log.warn("[deleteStudent:{}] ", "触发熔断方法");
    }
}
