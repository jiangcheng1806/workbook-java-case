package com.jiangcheng.entity;

import lombok.Data;

/**
 * 类名称：User<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Car car;
    public User(){
        System.out.println("创建了User对象");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
