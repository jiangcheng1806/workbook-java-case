package com.jiangcheng.theory.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public void testCondition(){
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
    public void testMapResuce(){
        System.out.println("jdk7-:");
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            total = total + price;
        }
        System.out.println("Total : " + total);
        System.out.println("jdk8+:");
        costBeforeTax.stream().map((cost)->cost+.12*cost).forEach(System.out::println);

        double bill = costBeforeTax.stream().map((cost)->cost+0.12*cost).reduce((sum,cost)->sum+cost).get();
        System.out.println("Total:"+bill);
    }

    /**
     * filter
     */
    public void testFilter(){
        List<String> strList = Arrays.asList("abc","","bcd","","defg","jk");
        // 创建一个字符串列表，每个字符串长度大于2
        List<String> filtered = strList.stream().filter(x->x.length()>2).collect(Collectors.toList());

        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }

    /**
     * function
     */
    public void testJoining(){
        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x->x.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(G7Countries);
    }

    /**
     * dstinct
     */
    public void testDistinct(){
        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }

    /**
     * function
     */
    public void testMain(){
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x)->x).summaryStatistics();
        System.out.println("Highest prime number in List : "+stats.getMax());
        System.out.println("Lowest prime number in List : "+stats.getMin());
        System.out.println("Sum of all prime numbers : "+stats.getSum());
        System.out.println("Average of all prime numbers : "+stats.getAverage());
    }
}
