package com.jiangcz.application.jdk.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        //add与roll的区别
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca1 = Calendar.getInstance();//2019-11-21 16:24:31
        Calendar ca2 = Calendar.getInstance();//2019-11-21 16:24:31
        ca1.add(Calendar.MONTH,3);//add加3个月
        ca2.roll(Calendar.MONTH,3);//roll加3个月
        System.out.println(sf.format(ca1.getTime()));//进位：2020-02-21 16:24:31
        System.out.println(sf.format(ca2.getTime()));//不进位：2019-02-21 16:24:31

    }

    public static void main1(String[] args) {

//add:基于日历规则实现日期加减
        System.out.println("#################### add #####################");
        Calendar cal = Calendar.getInstance();
        System.out.println("当前月份："+(cal.get(Calendar.MONTH)+1));
        cal.add(Calendar.MONTH,2);
        System.out.println("加上2个月："+(cal.get(Calendar.MONTH)+1));
        cal.add(Calendar.MONTH,-2);
        System.out.println("再加上-2个月："+(cal.get(Calendar.MONTH)+1));
    }

    public static void main2(String[] args) {
        Calendar calendar = Calendar.getInstance();
        //get:返回指定日历字段的值
        System.out.println("#################### get #####################");
        System.out.println("当前日期:"+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)
                +"-"+calendar.get(Calendar.DATE));
        System.out.println("当前时间:"+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)
                +":"+calendar.get(Calendar.SECOND)+":"+calendar.get(Calendar.MILLISECOND));
        System.out.println("12小时制:"+calendar.get(Calendar.HOUR));
        System.out.println("24小时制:"+calendar.get(Calendar.HOUR_OF_DAY));
    }

    public static void main3(String[] args) {
        //set:设置日历字段的值
        System.out.println("#################### set #####################");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2018);
        System.out.println("修改年份后："+calendar.get(Calendar.YEAR));
        calendar.set(2018, Calendar.MAY,13,15,1,11);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
    }
}
