package com.chanspace.displacement;

/**
 * 类名称：Displacement<br>
 * 类描述：<br>
 * 创建时间：2018年07月16日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class Displacement {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(6297));
        System.out.println(Integer.toBinaryString(-6297));
        System.out.println(Integer.toBinaryString(6297>>5));
        System.out.println(Integer.toBinaryString(-6297>>5));
        System.out.println(Integer.toBinaryString(6297>>>5));
        System.out.println(Integer.toBinaryString(-6297>>>5));
        System.out.println(Integer.toBinaryString(6297<<5));
        System.out.println(Integer.toBinaryString(-6297<<5));
    }
}
