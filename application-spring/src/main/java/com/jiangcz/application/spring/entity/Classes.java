package com.jiangcz.application.spring.entity;

import lombok.Data;

import java.util.List;

/**
 * 类名称：Classes<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Data
public class Classes {
    private int id;
    private String name;
    private List<Student> students;
}
