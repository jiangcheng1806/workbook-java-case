package com.jiangc.workbook.jdk.threadlocal;

public class ThreadLocalCopyTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set(){
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public Long getLong(){
        return longLocal.get();
    }

    public String getString(){
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalCopyTest test = new ThreadLocalCopyTest();
        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread = new Thread(){
          public void run(){
              test.set();
              System.out.println(test.getLong());
              System.out.println(test.getString());
          }
        };

        thread.start();
        thread.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
