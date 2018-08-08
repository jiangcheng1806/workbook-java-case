package com.jiangcheng.test;

import com.jiangcheng.theory.junit.Case;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * 类名称：ApplicationTest<br>
 * 类描述：<br>
 * 创建时间：2018年05月10日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
public class ApplicationTest {

    @Test
    public void begin() {
        Case application = new Case();
        assertEquals(application.begin(),"Application is begining!");
    }

    @Test
    public void end() {
        Case application = new Case();
        assertEquals(application.end(),"Application is ending!");
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        DataSource ds = (DataSource) applicationContext.getBean("dataSource");
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("myconn=======================>"+conn);

    }
}