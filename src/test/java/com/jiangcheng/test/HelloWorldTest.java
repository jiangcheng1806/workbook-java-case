package com.jiangcheng.test;

import com.jiangcheng.theory.junit.HelloWorld;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 类名称：HelloWorldTest<br>
 * 类描述：<br>
 * 创建时间：2018年05月10日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */
public class HelloWorldTest {

    @Test
    public void sayHello() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals(helloWorld.sayHello(),"Hello World!");
    }
}