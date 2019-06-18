package com.ww.service;

import com.ww.constant.DeleteState;
import com.ww.entity.Student;
import com.ww.pvo.StudentPvo;
import com.ww.repository.StudentRepository;
import com.ww.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: Sun
 * @create: 2019-06-13 16:31
 * @version: v1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentVo saveStudent(StudentPvo studentPvo) {
        Student student = new Student();
        student.setName(studentPvo.getName());
        student.setCreateTime(System.currentTimeMillis());
        student.setDeleteState(DeleteState.NORMAL);
        Student saveStudent = studentRepository.saveAndFlush(student);
        return new StudentVo(saveStudent.getId(), saveStudent.getName(), saveStudent.getCreateTime());
    }

    @Override
    public Integer deleteStudent(Integer studentId) {
        Optional<Student> byId = studentRepository.findById(studentId);
        if (!byId.isPresent()) {
            return null;
        }
        byId.get().setDeleteState(DeleteState.DELETED);
        Student student = studentRepository.saveAndFlush(byId.get());
        return student.getId();
    }

    @Override
    public List<StudentVo> findAll() {
        return studentRepository.findAll().stream().map(student ->
                new StudentVo(student.getId(), student.getName(), student.getCreateTime())).collect(Collectors.toList());
    }

    @Override
    public StudentVo findById(Integer studentId) {
        Optional<Student> byId = studentRepository.findById(studentId);
        if (!byId.isPresent()) {
            return null;
        }
        Student student = byId.get();
        return new StudentVo(student.getId(), student.getName(), student.getCreateTime());
    }
}
