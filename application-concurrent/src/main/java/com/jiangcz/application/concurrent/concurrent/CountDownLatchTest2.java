package com.jiangcz.application.concurrent.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest2 {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        new Thread(()->{
            try {
                System.out.println("子线程开始等待");
                System.out.println("子线程处理任务1----------------->"+System.currentTimeMillis());
                latch.await(5, TimeUnit.SECONDS);
                System.out.println("子线程等待结束");
                System.out.println("子线程处理任务2----------------->"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("主线程处理任务3----------------->"+System.currentTimeMillis());
        Thread.sleep(3000);
        latch.countDown();
        System.out.println("主线程处理任务4----------------->"+System.currentTimeMillis());
    }
}
