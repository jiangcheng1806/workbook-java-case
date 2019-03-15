package com.jiangcheng.theory.lambda;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 类名称：ReduceTest<br>
 * 类描述：<br>
 * 创建时间：2019年03月06日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class ReduceTest {


    /**
     * (acc,item) -> acc+=item
     * @param args
     */
    public static void main1(String[] args) {

        Optional accResult = Stream.of(1,2,3,4).reduce((acc,item) -> {
            System.out.println("acc : " + acc);
            acc += item;
            System.out.println("item : " + item);
            System.out.println("acc : " + acc);
            System.out.println("---------------------");
            System.out.println();
            return acc;
        });


        System.out.println("accResult: " + accResult.get());
        System.out.println("-----------------------------");
    }

    /**
     * (acc,item) -> acc+=item
     * @param args
     */
    public static void main2(String[] args) {

        int accResult = Stream.of(1,2,3,4).reduce(0,(acc,item) -> {
            System.out.println("acc : " + acc);
            acc += item;
            System.out.println("item : " + item);
            System.out.println("acc : " + acc);
            System.out.println("---------------------");
            System.out.println();
            return acc;
        });


        System.out.println("accResult: " + accResult);
        System.out.println("-----------------------------");
    }

    /**
     * bifunction operator
     * @param args
     */
    public static void main3(String[] args) {

        ArrayList<Integer> accResult = Stream.of(1,2,3,4).reduce(new ArrayList<Integer>(),
                (acc, item) -> {

                    acc.add(item);
                    System.out.println("item: " + item);
                    System.out.println("acc: " + acc);
                    System.out.println("BiFunction");

                    return acc;
                }, (acc, item) -> {

                    System.out.println("BinaryOperator");

                    acc.addAll(item);
                    System.out.println("item: " + item);
                    System.out.println("acc: " + acc);
                    System.out.println("--------------------");

                    return acc;
                });

        System.out.println("accResult: " + accResult);
        System.out.println("-----------------------------");
    }

    /**
     * Integer::sum
     * @param args
     */
    public static void main4(String[] args) {

        int accResult = Stream.of(1,2,3,4).reduce(0,Integer::sum);

        System.out.println("accResult: " + accResult);
        System.out.println("-----------------------------");

    }

    /**
     * BigDecimal::add
     * @param args
     */
    public static void main5(String[] args) {

        BigDecimal accResult = Stream.of(new BigDecimal(0),new BigDecimal(2),new BigDecimal(3),new BigDecimal(4)).reduce(new BigDecimal(0),BigDecimal::add);

        System.out.println("accResult: " + accResult);
        System.out.println("-----------------------------");
    }


    /**
     * range
     * @param args
     */
    public static void main6(String[] args) {

        double average = IntStream.range(1,10).summaryStatistics().getAverage();
        System.out.println(average);

        long sum = IntStream.range(1,10).summaryStatistics().getSum();
        System.out.println(sum);

        long count = IntStream.range(1,10).summaryStatistics().getCount();
        System.out.println(count);

    }


    /**
     * statistics
     * @param args
     */
    public static void main7(String[] args) {
        Stream<Integer> trans = Stream.of(11, 9, 2, 13, 1, 2, 99, 54, 23, 66, 70, 23, 46, 50, 100, 10, 24, 18, 19, 2);

        IntSummaryStatistics all = trans
// 前5条跳过，2, 99, 54, 23, 66, 70, 23, 46, 50, 100, 10, 24, 18, 19, 2
                .skip(5)
// 取10条考核交易 2, 99, 54, 23, 66, 70, 23, 46, 50, 100
                .limit(10)
// 将50以下的交易剔除 99, 54, 66, 70, 50, 100
                .filter(i -> i >= 50)
// 转换成数字。如果是IntStream 则不需要转换
                .mapToInt(i->i)
// 将流的统计结果放入包装对象中
                .summaryStatistics();
// 交易总量 439w，平均值为439/6
        System.out.println(all.getAverage());
    }


    /**
     *  常用流式操作
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = {2,3,4,5,6};

        // 将元素的平方打印出来
        Arrays.stream(nums)
                .map(i->i*i)
                .forEach(System.out::println);

        // 将元素中的所有偶数累加求和
        System.out.println(
                Arrays.stream(nums)
                        .map(i -> i % 2 == 0 ? i : 0)
                        .reduce(0, Integer::sum)
        );


        // flatMap处理嵌套的list
        List<List<Integer>> ll = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(11,22,33),
                Arrays.asList(0xF1,0xF2,0xF3)
        );
        ll.stream()
                .flatMap(list -> list.stream())
                .map(i -> 2 * i)
                .forEach(i -> System.out.println(i));

        //流的几种创建方式
        // 从数组创建
        int [] source = {1,2,3,4,5,6};
        IntStream s = Arrays.stream(source);
        s.forEach(System.out::println);

// 从集合创建
        List list = Arrays.asList(1,2,3,4,5);
        Stream s2 = list.stream();
        s2.forEach(System.out::println);
// 创建1到10的流
        IntStream s3 = IntStream.range(1,10);
//  直接创建
        Stream s4 = Stream.of("wo", "ai", "?");
        s4.forEach(System.out::println);
    }
}
