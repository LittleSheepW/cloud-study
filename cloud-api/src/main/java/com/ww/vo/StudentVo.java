package com.ww.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * StudentVo entity.
 * @author: Sun
 * @create: 2019-06-13 11:28
 * @version: v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo implements Serializable {

    private Integer id;

    private String name;

    private Long createTime;

}
