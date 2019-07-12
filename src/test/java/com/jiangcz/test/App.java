package com.jiangcz.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.mockito.ArgumentCaptor;

import java.util.*;

import static org.mockito.Mockito.*;

/**
 * 类名称：App<br>
 * 类描述：<br>
 * 创建时间：2018年05月10日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class App {
    public static void main(String args[]){
        Result result = JUnitCore.runClasses(ApplicationTest.class);
        for (Failure failure:result.getFailures()){
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()){
            System.out.println("Both Tests finished successfully...");
        }
    }

    /**
     * 创建 Mock 对象
     */
    @Test
    public void createMockObject(){
        //使用mock静态方法创建Mock对象
        List mockedList = mock(List.class);
        Assert.assertTrue(mockedList instanceof List);

        // mock 方法不仅可以 Mock 接口类, 还可以 Mock 具体的类型.
        ArrayList mockedArrayList = mock(ArrayList.class);
        Assert.assertTrue(mockedArrayList instanceof List);
        Assert.assertTrue(mockedArrayList instanceof ArrayList);
    }


    /**
     * 配置 Mock 对象
     */
    @Test
    public void configMockObject(){
        List mockedList = mock(List.class);

        // 我们定制了当调用 mockedList.add("one") 时, 返回 true
        when(mockedList.add("one")).thenReturn(true);
        // 当调用 mockedList.size() 时, 返回 1
        when(mockedList.size()).thenReturn(1);

        Assert.assertTrue(mockedList.add("one"));
        // 因为我们没有定制 add("two"), 因此返回默认值, 即 false.
        Assert.assertFalse(mockedList.add("two"));
        Assert.assertEquals(mockedList.size(),1);

        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello,").thenReturn("Mockito!");
        String result = i.next() + "" + i.next();
        //assert
        Assert.assertEquals("Hello,Mockito!",result);
    }

    /**
     * 制定抛出异常
     */
    @Test(expected = NoSuchElementException.class)
    public void testForIOException(){
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello,").thenReturn("Mockito!");//1
        String result = i.next() + "" + i.next();//2
        Assert.assertEquals("Hello,Mockito!",result);
        //上面代码的第一第二步我们已经很熟悉了, 接下来第三部我们使用了一个新语法: doThrow(ExceptionX).when(x).methodCall, 它的含义是: 当调用了 x.methodCall 方法后, 抛出异常 ExceptionX.
        //因此 doThrow(new NoSuchElementException()).when(i).next() 的含义就是: 当第三次调用 i.next() 后, 抛出异常 NoSuchElementException.(因为 i 这个迭代器只有两个元素)
        doThrow(new NoSuchElementException()).when(i).next();//3
        i.next();//4
    }

    /**
     * 校验 Mock 对象的方法调用
     */
    @Test
    public void testVerify(){
        List mockedList =  mock(List.class);
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");
        when(mockedList.size()).thenReturn(5);
        Assert.assertEquals(mockedList.size(),5);

        //第一句校验 mockedList.add("one") 至少被调用了 1 次(atLeastOnce)
        verify(mockedList,atLeastOnce()).add("one");
        //第二句校验 mockedList.add("two") 被调用了 1 次(times(1))
        verify(mockedList,times(1)).add("two");
        //第三句校验 mockedList.add("three times") 被调用了 3 次(times(3))
        verify(mockedList,times(3)).add("three times");
        //第四句校验 mockedList.isEmpty() 从未被调用(never)
        verify(mockedList,never()).isEmpty();
    }


    @Test
    public void testSpy(){
        List list = new LinkedList();
        List spy = spy(list);

        // 对 spy.size() 进行定制.
        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        // 因为我们没有对 get(0), get(1) 方法进行定制,
        // 因此这些调用其实是调用的真实对象的方法.
        Assert.assertEquals(spy.get(0),"one");
        Assert.assertEquals(spy.get(1),"two");
        //我们 定义了 spy.size() 的返回值, 因此当调用 spy.size() 时, 返回 100.
        Assert.assertEquals(spy.size(),100);
    }

    @Test
    public void testCaptureArgument(){
        List<String> list = Arrays.asList("1","2");
        List mockedList = mock(List.class);
        ArgumentCaptor<List> argument = ArgumentCaptor.forClass(List.class);
        mockedList.addAll(list);
        verify(mockedList).addAll(argument.capture());

        Assert.assertEquals(2,argument.getValue().size());
        Assert.assertEquals(list,argument.getValue());
    }
}
