package com.ww.service;

import com.ww.pvo.StudentPvo;
import com.ww.vo.StudentVo;

import java.util.List;

/**
 * Client service interface.
 *
 * @author: Sun
 * @create: 2019-04-25 10:19
 * @version: v1.0
 */
public interface ClientService {

    /**
     * 通过id获取Student (通过RestTemplate进行服务调用)
     *
     * @param:
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-04-25 11:48
     */
    StudentVo getStudentByRestTemplate(Integer id);

    /**
     * 保存学生 (通过RestTemplate进行服务调用)
     * @param student
     */
    StudentVo saveStudentByRestTemplate(StudentPvo student);

    /**
     * 查询Student List (通过RestTemplate进行服务调用)
     * @param:
     * @throws:
     * @return: java.util.List<com.ww.vo.StudentVo>
     * @author: Sun
     * @date: 2019-06-18 17:18
     */
    List<StudentVo> getStudentListByRestTemplate();

    /**
     * 通过id获取Student (通过Feign进行服务调用)
     * @param:
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-04-25 11:48
     */
    StudentVo getStudentByFeign(Integer id);

    /**
     * 保存学生 (通过Feign进行服务调用)
     * @param student
     * @return
     */
    StudentVo saveStudentByFeign(StudentPvo student);

    /**
     * 查询学生列表 (通过Feign进行服务调用)
     * @param
     * @return
     */
    List<StudentVo> getStudentListByFeign();

}
