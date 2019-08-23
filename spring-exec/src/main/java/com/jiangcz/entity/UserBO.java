package com.jiangcz.entity;

import lombok.Data;

/**
 * 类名称：UserBO<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Data
public class UserBO {
    private int id;
    private String name;
    private int age;
    private Car car;
    public UserBO(){
        System.out.println("创建了User对象");
    }

    @Override
    public String toString() {
        return "UserBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
