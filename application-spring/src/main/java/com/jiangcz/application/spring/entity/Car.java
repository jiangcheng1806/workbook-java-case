package com.jiangcz.application.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类名称：Car<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private int num;
    private String brand;
    /*public Car(){
        System.out.println("创建了Car对象");
    }*/
    @Override
    public String toString() {
        return "Car [num=" + num + ", brand=" + brand + "]";
    }
}
