package com.chanspace.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 类名称：LambdaTest<br>
 * 类描述：lambda测试http://www.importnew.com/16436.html<br>
 * 创建时间：2018年05月21日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class LambdaTest {
    public static void main(String[] args) {

        new LambdaTest().testMain();

    }

    /**
     * 用lambda表达式实现Runnable
     */
    public void testRunnable(){

        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();

        //Java 8方式：
        new Thread(() -> System.out.println("In java8,Lambda expression rocks!!")).start();
    }


    /**
     * 使用lambda表达式对列表进行迭代
     *
     */
    public void testForEach(){
        // Java 8之前：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println("jdk7-:"+feature);
        }

        features.forEach( n -> System.out.println("jdk8+:"+n));

        features.forEach( System.out :: println);
    }

    /**
     * 使用lambda表达式和函数式接口Predicate
     */
    public void testFilter(){
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages,((str) -> str.toString().startsWith("J")));

        System.out.println("Languages which ends with a ");
        filter(languages,(str) -> str.toString().endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages,(str) -> true);

        System.out.println("Print no language : ");
        filter(languages,(str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages,(str)->str.toString().length()>4);
    }

    public static void filter(List<String> names, Predicate condition){
        /*for (String name : names){
            if (condition.test(name)){
                System.out.println(name + "");
            }
        }*/
        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + "--------------->it's jdk8 method result");
        });
    }

    /**
     * 如何在lambda表达式中加入Predicate
     */
    public void testPredicate(){
        List names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
// 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        Predicate startsWtithJ = (n)->n.toString().startsWith("J");

        Predicate fourLetterLong = (n)->n.toString().length()==4;

        names.stream().filter(startsWtithJ.and(fourLetterLong)).forEach((n)-> System.out.println("nName, which starts with 'J' and four letter long is : " + n));
    }


    /**
     * Java 8中使用lambda表达式的Map和Reduce示例
     */
    public void testMain(){
        System.out.println("jdk7-:");
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }
        System.out.println("jdk8+:");
        costBeforeTax.stream().map((cost)->cost+.12*cost).forEach(System.out::println);
    }
}
