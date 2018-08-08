package com.jiangcheng.theory.aop;

/**
 * 类名称：CalImplTest<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
public class CalImplTest {
    public static void main(String[] args) {
        //被代理对象
        Cal cal = new CalImpl();
        MyInvocationHandler mh = new MyInvocationHandler();
        //代理对象
        Cal cal1 = (Cal) mh.bind(cal);
        cal1.add(10,3);
        cal1.sub(10,3);
        cal1.mul(10,3);
        cal1.div(10,3);
    }

}