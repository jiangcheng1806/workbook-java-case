package com.jiangcheng.test;

import com.jiangcheng.theory.junit.HelloWorld;
import org.junit.Test;

import java.util.Arrays;

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


    @Test
    public void testContains() {
        String vehicle = "赣K83207";

        String vehicle1 = "赣K83207赣K80735挂";

        boolean f = vehicle1.contains(vehicle);

        System.out.println("res : "+f);



        String vehicle2 = "";
        String[] vehicle_arr = vehicle2.split(",");
        System.out.println(Arrays.toString(vehicle_arr));



    }
}