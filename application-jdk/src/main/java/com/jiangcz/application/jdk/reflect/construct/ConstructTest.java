package com.jiangcz.application.jdk.reflect.construct;

import java.lang.reflect.Constructor;

public class ConstructTest {
    public static void main(String[] args) {
        //获取class对象
        Class<A> aClass = A.class;

        //获取构造方法
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors){
            System.out.println("构造方法=====>"+constructor);
        }
    }
}
