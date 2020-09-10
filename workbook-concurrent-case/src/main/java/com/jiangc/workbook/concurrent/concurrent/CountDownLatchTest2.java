package com.jiangc.workbook.concurrent.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest2 {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"子线程开始等待----------------->"+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"子线程处理任务1----------------->"+System.currentTimeMillis());
                latch.await(2, TimeUnit.SECONDS); //超时之后继续执行子任务了 不会再等待 countdownlatch 了
                //latch.await();
                System.out.println(Thread.currentThread().getName()+"子线程等待结束");
                System.out.println(Thread.currentThread().getName()+"子线程处理任务2----------------->"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"子线程开始等待----------------->"+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"子线程处理任务1----------------->"+System.currentTimeMillis());
                latch.await(3, TimeUnit.SECONDS);
                //latch.await();
                System.out.println(Thread.currentThread().getName()+"子线程等待结束");
                System.out.println(Thread.currentThread().getName()+"子线程处理任务2----------------->"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("主线程处理任务3----------------->"+System.currentTimeMillis());
        Thread.sleep(10000);
        latch.countDown();// 如果latch 变量是 2 则一次 countdown 之后 所有子线程 仍然 再等待
        System.out.println("主线程处理任务4----------------->"+System.currentTimeMillis());
        latch.countDown();
        System.out.println("主线程处理完毕");
    }
}
