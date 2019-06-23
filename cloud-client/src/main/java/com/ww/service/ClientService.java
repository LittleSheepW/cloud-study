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

    List getStudentListByRestTemplate();

    StudentVo getStudentByRestTemplate(Integer id);

    StudentVo saveStudentByRestTemplate(StudentPvo student);

    void updateStudentByRestTemplate(StudentPvo studentPvo);

    void deleteStudentByRestTemplate(Integer id);

    /**
     * 以上是通过RestTemplate方式进行服务调用
     * ------------------------------------------------
     * 以下是通过Feign进行调用
     */

    List<StudentVo> getStudentListByFeign();

    StudentVo getStudentByFeign(Integer id);

    StudentVo saveStudentByFeign(StudentPvo student);

    void updateStudentByFeign(StudentPvo studentPvo);

    void deleteStudentByFeign(Integer id);
}
