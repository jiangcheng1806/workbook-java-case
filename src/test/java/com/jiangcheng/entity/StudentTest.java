package com.jiangcheng.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类名称：StudentTest<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
public class StudentTest {

    public static void main(String[] args) {
        //Student student = new Student();
        //System.out.println(student);

        //1.加载spring.xml配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //2.通过id获取值对象
        //Student stu = applicationContext.getBean(Student.class);//No qualifying bean of type 'com.jiangcheng.entity.Student' available: expected single matching bean but found 2: stu,stu2
        //Student stu = (Student) applicationContext.getBean("stu");///Student(id=1, name=<张三>, age=23)
        //Student stu = (Student) applicationContext.getBean("stu3");///Student(id=1, name=<张三>, age=23)
        //Student stu = (Student) applicationContext.getBean("stu4");///Student(id=1, name=<张三>, age=23)
        //Classes classes = (Classes) applicationContext.getBean("classes");
        //System.out.println(classes);




        UserBO user = (UserBO) applicationContext.getBean("user");
        //UserBO user1 = (UserBO) applicationContext.getBean("user");
        //UserBO user2 = (UserBO) applicationContext.getBean("user2");
        //user的scope为prototype时是false,默认是true
        //System.out.println(user == user1);
        //System.out.println(user2);
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);


    }
}