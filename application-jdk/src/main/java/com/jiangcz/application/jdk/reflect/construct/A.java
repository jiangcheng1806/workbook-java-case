package com.jiangcz.application.jdk.reflect.construct;

import lombok.Data;

@Data
public class A {
    private String s;
    public A(String s){
        this.s = s;
    }
}
