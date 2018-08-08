package com.jiangcheng.entity;

import lombok.Data;

/**
 * 类名称：Car<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Data
public class Car {
    private int id;
    private String brand;
    public Car(){
        System.out.println("创建了Car对象");
    }
}
