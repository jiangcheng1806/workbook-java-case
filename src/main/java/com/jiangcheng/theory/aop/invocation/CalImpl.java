package com.jiangcheng.theory.aop.invocation;

import org.springframework.stereotype.Component;

/**
 * 类名称：CalImpl<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
@Component("calLogger")
public class CalImpl implements Cal {
    @Override
    public int add(int num1, int num2) {
        //System.out.println("add方法的参数是["+num1+","+num2+"]");
        int result = num1 + num2;
        //System.out.println("add方法的结果是"+result);
        return result;
    }

    @Override
    public int sub(int num1, int num2) {
        //System.out.println("sub方法的参数是["+num1+","+num2+"]");
        int result = num1 - num2;
        //System.out.println("sub方法的结果是"+result);
        return result;
    }

    @Override
    public int mul(int num1, int num2) {
        //System.out.println("mul方法的参数是["+num1+","+num2+"]");
        int result = num1 * num2;
        //System.out.println("mul方法的结果是"+result);
        return result;
    }

    @Override
    public int div(int num1, int num2) {
        //System.out.println("div方法的参数是["+num1+","+num2+"]");
        int result = num1 / num2;
        //System.out.println("div方法的结果是"+result);
        return result;
    }
}
