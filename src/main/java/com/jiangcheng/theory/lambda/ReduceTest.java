package com.jiangcheng.theory.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
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

    public static void main3(String[] args) {

        ArrayList<Integer> accResult = Stream.of(1,2,3,4).reduce(new ArrayList<Integer>(),
                new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {

                acc.add(item);
                System.out.println("item: " + item);
                System.out.println("acc: " + acc);
                System.out.println("BiFunction");

                return acc;
            }
        }, new BinaryOperator<ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {

                System.out.println("BinaryOperator");

                acc.addAll(item);
                System.out.println("item: " + item);
                System.out.println("acc: " + acc);
                System.out.println("--------------------");

                return acc;
            }
        });

        System.out.println("accResult: " + accResult);
        System.out.println("-----------------------------");
    }

    public static void main4(String[] args) {

        ArrayList<Integer> accResult = Stream.of(1,2,3,4).reduce(new ArrayList<Integer>(),
                new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {

                        acc.add(item);
                        System.out.println("item: " + item);
                        System.out.println("acc: " + acc);
                        System.out.println("BiFunction");

                        return acc;
                    }
                }, new BinaryOperator<ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {

                        System.out.println("BinaryOperator");

                        acc.addAll(item);
                        System.out.println("item: " + item);
                        System.out.println("acc: " + acc);
                        System.out.println("--------------------");

                        return acc;
                    }
                });

        System.out.println("accResult: " + accResult);
        System.out.println("-----------------------------");
    }

    public class User {
        private long id;
        private BigDecimal money;

        public User(long id, BigDecimal money) {
            this.id = id;
            this.money = money;
        }
        // getter&setter
    }

}
