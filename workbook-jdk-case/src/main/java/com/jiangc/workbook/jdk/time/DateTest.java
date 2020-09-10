package com.jiangc.workbook.jdk.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date newDate1 = formatter.parse("2019-12-31 23:59:59");
        System.out.println(newDate1);

        SimpleDateFormat formatter2 = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        Date newDate2 = formatter2.parse("2019-12-31 23:59:59");
        System.out.println(newDate2);

        SimpleDateFormat formatter3 = new SimpleDateFormat("YYYY-MM-DD");
        Date newDate3 = formatter3.parse("2020-01-01");
        System.out.println(newDate3);
    }



    public static void main1(String[] args) {
        Date date1  = new Date();
        Date date2 = new Date(System.currentTimeMillis()+1000);
        System.out.println("date1: "+date1);//date1: Thu Nov 21 13:54:52 CST 2019
        System.out.println("date2: "+date2);//date2: Thu Nov 21 13:54:53 CST 2019
        System.out.println("date1.compareTo(date2): "+date1.compareTo(date2));//-1
        System.out.println("date1.after(date2): "+date1.after(date2));//false
        System.out.println("date1.before(date2): "+date1.before(date2));//true
        System.out.println("date1.getTime(): "+date1.getTime());//1574315692607
        date1.setTime(System.currentTimeMillis());
        System.out.println("setTime() ==> date1.getTime(): "+date1.getTime());//1574315692628
    }
}
