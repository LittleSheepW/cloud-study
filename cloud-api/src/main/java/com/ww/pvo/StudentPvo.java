package com.ww.pvo;


import lombok.Data;

/**
 * StudentPvo entity.
 * @author: Sun
 * @create: 2019-06-13 11:28
 * @version: v1.0
 */
@Data
public class StudentPvo {

    private Integer id;

    private Integer studentId;

    private String name;

    private Long createTime;

    private Integer deleteState;

}
