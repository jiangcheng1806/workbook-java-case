package com.jiangc.workbook.jdk.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前年份:" + (localDateTime.getYear()-4)); // 2020
        System.out.println("当前日份:" + localDateTime.getDayOfMonth()); // 11
        System.out.println("--------------------");
        String result1 = localDateTime.format(DateTimeFormatter.ISO_DATE);
        String result2 = localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        String result3 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("格式化后的日期result1：" + result1);
        System.out.println("格式化后的日期result2：" + result2);
        System.out.println("格式化后的日期result3：" + result3);
    }
}
