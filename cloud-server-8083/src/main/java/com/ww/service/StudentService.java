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
    List<StudentVo> findAll();

    StudentVo findById(Integer studentId);

    StudentVo saveStudent(StudentPvo studentPvo);

    void updateStudent(StudentPvo studentPvo);

    void deleteStudent(Integer studentId);
}
