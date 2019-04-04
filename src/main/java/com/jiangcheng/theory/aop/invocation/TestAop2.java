package com.jiangcheng.theory.aop.invocation;

/**
 * 类名称：TestAop2<br>
 * 类描述：<br>
 * 创建时间：2019年04月04日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class TestAop2 {

    public static void main(String[] args) {
        Cal cal = new CalImpl();
        MyInvocationHandler handler = new MyInvocationHandler();
        Cal cal1 = (Cal) handler.bind(cal);
        cal1.add(1,2);
    }
}
