package com.jiangcheng.theory.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类名称：StreamTest<br>
 * 类描述：<br>
 * 创建时间：2019年03月07日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class StreamTest {

    /**
     * stream 转 list
     */
    public static void fun1(String[] args) {

        List<Integer> collectList = Stream.of(1,2,3,4).collect(Collectors.toList());

        System.out.println("collectList: "+collectList);
    }

    /**
     * 求最大值
     */
    public static void fun2(String[] args) {

        Optional<Integer> max = Stream.of(1,2,3,4).collect(Collectors.maxBy(Comparator.comparingInt(o -> o)));

        System.out.println("max: "+max.get());
    }

    /**
     * 分割数据块
     */
    public static void fun3(String[] args) {

        Map<Boolean,List<Integer>> partions = Stream.of(1,2,3,4).collect(Collectors.partitioningBy(it -> it % 2 == 0));

        System.out.println("partions: "+partions);
    }

    /**
     * 数据分组
     */
    public static void fun4(String[] args) {

        //Map<Boolean,List<Integer>> groups = Stream.of(1,2,3,4).collect(Collectors.groupingBy(it -> it % 2 == 0));
        Map<Boolean,List<Integer>> groups = Stream.of(1,2,3,4).collect(Collectors.groupingBy(it -> it > 3));
        System.out.println("groups: "+groups);
    }

    /**
     * 字符串拼接
     */
    public static void fun5(String[] args) {

        String joing = Stream.of("1","2","3","4").collect(Collectors.joining(",","[","]"));
        System.out.println("joing: \""+joing+"\"");
    }

    /**
     * reduce
     */
    public static void fun6(String[] args) {

        //Integer reduce1 = Stream.of(1,2,3,4).reduce(100,(sum, item) -> sum + item);
        Integer reduce2 = Stream.of(1,2,3,4).reduce(100,Integer::sum);

        System.out.println("reduce1: "+reduce2);
    }

    /**
     * orElse + findFirst
     */
    public static void main(String[] args) {

        //Integer reduce1 = Stream.of(1,2,3,4).reduce(100,(sum, item) -> sum + item);
        Integer first = Stream.of(1,2,3,4).findFirst().orElse(null);

        System.out.println("orElse + findFirst: "+first);
    }

}
