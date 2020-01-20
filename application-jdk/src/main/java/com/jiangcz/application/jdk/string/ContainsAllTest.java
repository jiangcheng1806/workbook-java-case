package com.jiangcz.application.jdk.string;

import java.util.Arrays;
import java.util.List;

public class ContainsAllTest {
    public static void main(String[] args) {


        String s1 = "123501;123525;123526;123527;123528;123529";
        String s2 = "123525;123614";

        List<String> list1= Arrays.asList(s1.split(";"));
        List<String> list2= Arrays.asList(s2.split(";"));

        boolean b = list1.containsAll(list2);

        System.out.println(b?"全包含":"非全包含");






    }
}
