package com.ww.service;

import com.ww.api.ApiStatus;
import com.ww.constant.DbSource;
import com.ww.constant.DeleteState;
import com.ww.entity.Student;
import com.ww.exception.StudentException;
import com.ww.pvo.StudentPvo;
import com.ww.repository.StudentRepository;
import com.ww.vo.StudentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Sun
 * @create: 2019-06-13 16:31
 * @version: v1.0
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentVo> findAll() {
        List<Student> studentList = studentRepository.findAllByDeleteStateIs(DeleteState.NORMAL);
        if (CollectionUtils.isEmpty(studentList)) {
            return new ArrayList<>();
        }
        return studentList.stream().map(student ->
                new StudentVo(student.getId(), student.getName(), student.getCreateTime(), student.getDbSource())).collect(Collectors.toList());
    }

    @Override
    public StudentVo findById(Integer studentId) {
        Student student = studentRepository.findByIdAndDeleteStateIs(studentId, DeleteState.NORMAL);
        if (ObjectUtils.isEmpty(student)) {
            return null;
        }
        return new StudentVo(student.getId(), student.getName(), student.getCreateTime(), student.getDbSource());
    }

    @Override
    public StudentVo saveStudent(StudentPvo studentPvo) {
        Student student = new Student();
        student.setName(studentPvo.getName());
        student.setCreateTime(System.currentTimeMillis());
        student.setDeleteState(DeleteState.NORMAL);
        student.setDbSource(DbSource.DB_THREE);
        Student saveStudent = studentRepository.saveAndFlush(student);
        log.info("[saveStudent] [保存学生成功] [saveStudent:{}]", saveStudent);
        return new StudentVo(saveStudent.getId(), saveStudent.getName(), saveStudent.getCreateTime(), saveStudent.getDbSource());
    }

    @Override
    public void updateStudent(StudentPvo studentPvo) {
        Student student = studentRepository.findByIdAndDeleteStateIs(studentPvo.getId(), DeleteState.NORMAL);
        if (ObjectUtils.isEmpty(student)) {
            log.warn("[updateStudent] [学生不存在] [studentId:{}]", studentPvo.getId());
            throw new StudentException(ApiStatus.STUDENT_DOES_NOT_EXIST);
        }

        student.setName(studentPvo.getName());
        studentRepository.saveAndFlush(student);
        log.info("[updateStudent] [更新学生成功] [student:{}]", student);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        Student student = studentRepository.findByIdAndDeleteStateIs(studentId, DeleteState.NORMAL);
        if (ObjectUtils.isEmpty(student)) {
            log.warn("[updateStudent] [学生不存在] [studentId:{}]", studentId);
            throw new StudentException(ApiStatus.STUDENT_DOES_NOT_EXIST);
        }
        student.setDeleteState(DeleteState.DELETED);
        studentRepository.saveAndFlush(student);
        log.info("[deleteStudent] [删除学生成功] [studentId:{}]", student.getId());
    }
}
