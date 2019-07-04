package com.ww.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The Student entity.
 * @author: Sun
 * @create: 2019-06-13 11:28
 * @version: v1.0
 */
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 删除状态 {@link com.ww.constant.DeleteState}
     */
    private Integer deleteState;

    /**
     * 数据源 {@link com.ww.constant.DbSource}
     */
    private String dbSource;

}
