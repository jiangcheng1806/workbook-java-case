package com.jiangc.workbook.jdk.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringJoinTest {
    public static void main(String[] args) {
        String s = "1";


        List<String> list = Arrays.asList(s.split(","));
        String s1 = StringUtils.join(list,",");
//        String s1 = StringUtils.join(Collections.singletonList(s),",");
        System.out.println(s1);
    }
}
