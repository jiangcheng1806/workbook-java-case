package com.jiangcz.application.jdk.reflect.construct;

import lombok.Data;

@Data
@MyAnnotation(name = "小灰灰",value = "懒羊羊")
public class A extends B{
    private String s;
    public A(String s){
        this.s = s;
    }
    public A(){}
}
