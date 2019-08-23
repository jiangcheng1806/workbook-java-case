package com.jiangcz.application.datastructure.Integer;

/**
 * 类名称：IntegerTest<br>
 * 类描述：<br>
 * 创建时间：2019年01月25日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class IntegerTest {


    public static void main(String[] args) {
        Integer a = new Integer(20);
        Integer b = new Integer(20);

        System.out.println("a == b :" + (a == b));

        Integer i = 15;
        Integer i2 = 15;

        System.out.println("i == i2 :" + (i == i2));



        Integer j = new Integer(15);

        System.out.println("i == j :" + (i == j));




    }
}
