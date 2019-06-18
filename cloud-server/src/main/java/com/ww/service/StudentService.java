package com.ww.service;

import com.ww.pvo.StudentPvo;
import com.ww.vo.StudentVo;

import java.util.List;

/**
 * @author: Sun
 * @create: 2019-06-13 16:31
 * @version: v1.0
 */
public interface StudentService {

    StudentVo saveStudent(StudentPvo studentPvo);

    Integer deleteStudent(Integer studentId);

    List<StudentVo> findAll();

    StudentVo findById(Integer studentId);
}
