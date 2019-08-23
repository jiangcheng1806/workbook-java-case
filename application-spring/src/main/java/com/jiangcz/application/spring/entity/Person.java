package com.jiangcz.application.spring.entity;

import lombok.Data;

/**
 * 类名称：Person<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Data
public class Person {
    private int id;
    private String name;
    private Car car;
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", car=" + car + "]";
    }
}
