package com.jiangc.workbook.concurrent.concurrent;

import java.text.MessageFormat;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 类名称：CyclicBarrierTest<br>
 * 类描述：栅栏的重用<br>
 * CyclicBarrier 和 CountDownLatch 的区别
 * CountDownLatch	CyclicBarrier
 * 减计数方式	加计数方式
 * 计算为0时释放所有等待的线程	计数达到指定值时释放所有等待线程
 * 计数为0时，无法重置	计数达到指定值时，计数置为0重新开始
 * 调用countDown()方法计数减一，调用await()方法只进行阻塞，对计数没任何影响	调用await()方法计数加1，若加1后的值不等于构造方法的值，则线程阻塞
 * 不可重复利用	可重复利用
 *
 *
 *
 * 创建时间：2019年04月19日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class CyclicBarrierTest3 {


    public static void main(String[] args) {
        int N  = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("CyclicBarrier重用");

        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread{

        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(MessageFormat.format("线程 {0} 正在写入数据。。。",Thread.currentThread().getName()));
            try {
                Thread.sleep(5000);
                System.out.println(MessageFormat.format("线程 {0} 写入数据完毕,等待其他线程写入完毕",Thread.currentThread().getName()));
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println("所有线程写入完毕，继续处理其他任务。。。");
        }
    }
}
