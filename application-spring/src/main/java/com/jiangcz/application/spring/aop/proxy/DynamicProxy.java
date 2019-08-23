package com.jiangcz.application.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类名称：DynamicProxy<br>
 * 类描述：<br>
 * 创建时间：2019年04月04日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class DynamicProxy {
}

interface Subject{
    void action();
}

//被代理类
class RealSubject implements Subject {

    @Override
    public void action() {
        System.out.println("被代理类执行");
    }
}

class MyInvocationHandler2 implements InvocationHandler {

    //接口被代理对象的声明
    Object object;

    //给被代理

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}