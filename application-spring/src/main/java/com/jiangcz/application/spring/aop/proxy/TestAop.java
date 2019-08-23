package com.jiangcz.application.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 类名称：TestAop<br>
 * 类描述：<br>
 * 创建时间：2019年04月04日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class TestAop {

    public static void main(String[] args) {

        //创建了一个被代理类的对象
        SuperMan superMan = new SuperMan();

        //返回一个代理类的对象
        Object object = MyProxy.getProxyInstance(superMan);

        Human hu = (Human) object;

        //通过代理类的对象调用重写的抽象方法
        hu.info();

        System.out.println();

        hu.fly();
    }
}

interface Human {
    void info();

    void fly();
}

//被代理类
class SuperMan implements Human {

    @Override
    public void info() {
        System.out.println("登临碣石");
    }

    @Override
    public void fly() {
        System.out.println("以观沧海");
    }
}

class HumanUtil{
    public void method1(){
        System.out.println("----------方法一----------");
    }

    public void method2(){
        System.out.println("----------方法二----------");
    }
}

class MyInvocationHandler implements InvocationHandler {

    //被代理对象的声明
    Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil hu = new HumanUtil();
        hu.method1();

        Object returnVal = method.invoke(object,args);

        hu.method2();

        return returnVal;
    }
}

//动态的创建一个代理对象
class MyProxy{

    public static Object getProxyInstance(Object object){

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setObject(object);

        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),handler);
    }
}