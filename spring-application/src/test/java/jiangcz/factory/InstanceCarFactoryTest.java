package com.jiangcz.factory;

import com.jiangcz.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类名称：InstanceCarFactoryTest<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
public class InstanceCarFactoryTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("src/main/resources/spring.xml");
        Car car = (Car) applicationContext.getBean("car3");
        System.out.println(car);
    }
}