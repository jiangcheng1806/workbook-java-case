package com.jiangcheng.controller;

import com.jiangcheng.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * 类名称：UserControllerTest<br>
 * 类描述：<br>
 * 创建时间：2018年08月08日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
public class UserControllerTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserController userController = (UserController) applicationContext.getBean("userController");
        User user = userController.getUserById(1);
        System.out.println(user);
    }
}