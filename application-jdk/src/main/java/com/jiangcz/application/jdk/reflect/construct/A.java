package com.jiangcz.application.jdk.reflect.construct;

import lombok.Data;

@Data
public class A extends B{
    private String s;
    public A(String s){
        this.s = s;
    }
    public A(){}
}
