package com.jiangcz.application.jdk.bigdecimal;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal(1.23);
        BigDecimal d2 = new BigDecimal("1.23");
        BigDecimal d3 = new BigDecimal(1.23);

        System.out.println("d1>>>>>>>>>"+d1.toString() +",d2>>>>>>>>"+d2.toString() );
        System.out.println("d1>>>>>>>>>"+d1.toString() +",d3>>>>>>>>"+d3.toString() );

        System.out.println(">>>>>>>>>>>>>>>>>d1 = d2 :"+(d1 == d2));
        System.out.println(">>>>>>>>>>>>>>>>>d1 = d3 :"+(d1 == d3));
        System.out.println(">>>>>>>>>>>>>>>>>d1 equals d2 :"+(d1.equals(d2)));
        System.out.println(">>>>>>>>>>>>>>>>>d1 equals d3 :"+(d1.equals(d3)));
        System.out.println(">>>>>>>>>>>>>>>>>d1 compare d2 :"+(d1.compareTo(d2)));
        System.out.println(">>>>>>>>>>>>>>>>>d1 compare d3 :"+(d1.compareTo(d3)));

    }
}
