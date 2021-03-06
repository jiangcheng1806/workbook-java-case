package com.jiangc.workbook.concurrent.thread.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 类名称：Priority<br>
 * 类描述：<br>
 * 创建时间：2018年08月29日<br>
 *
 * @author jiangcheng
 * @version 1.0.0
 */

public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    static class Job implements Runnable{
        private int priority;
        private long jobCount;
        public Job(int priority){
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart){
                Thread.yield();
            }
            while (notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //设置优先级
            int priority = i < 5 ? Thread.MIN_PRIORITY:Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job,"Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(2);
        notEnd = false;
        for (Job job : jobs){
            System.out.println("Job Priority :" + job.priority + ",Count :" + job.jobCount);
        }
    }
}
