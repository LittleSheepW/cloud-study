package com.ww.repository;

import com.ww.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *
 * @author: Sun
 * @create: 2019-06-13 11:29
 * @version: v1.0
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    /**
     * 通过学生id和删除状态查询学生
     * @param studentId
     * @param deleteState
     * @return
     */
    Student findByIdAndDeleteStateIs(Integer studentId, Integer deleteState);

    /**
     * 查询未删除的学生列表
     * @param deleteState
     * @return
     */
    List<Student> findAllByDeleteStateIs(Integer deleteState);
}
