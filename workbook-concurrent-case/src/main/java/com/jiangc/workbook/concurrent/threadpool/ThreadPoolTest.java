package com.jiangc.workbook.concurrent.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 写个简单线程池应用例子
 * @author Chan Kiang
 *
 */
public class ThreadPoolTest {

	public static void main(String[] args) {
		
		//corePoolSize 5 maximumPoolSize 10 keepAliveTime 200 unit workQueue threadFactory handle
		//workQueue 多使用 linkedBlockingQueue和SychronizeQueue,也是用ArrayBlockingQueue和SynchronousQueue
		//handle 包括ThreadPoolExecutor.AbortPolicy、ThreadPoolExecutor.DiscardPolicy、ThreadPoolExecutor.DiscardOldestPolicy、ThreadPoolExecutor.CallerRunsPolicy
		//Executors.newCachedThreadPool();  //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE 
		//Executors.newSingleThreadExecutor();   
		//创建容量为1的缓冲池    Executors.newFixedThreadPool(int);    //创建固定容量大小的缓冲池
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));

		/**
		 * 下列三种业务，应该如何使用线程池：
		 * 高并发、任务执行时间短的业务
		 * 高并发、任务执行时间短的业务，线程池线程数可以设置为CPU核数+1，减少线程上下文的切换
		 *
		 * 并发不高、任务执行时间长的业务
		 * 并发不高、任务执行时间长的业务要区分开看：
		 * 　　a）假如是业务时间长集中在IO操作上，也就是IO密集型的任务，因为IO操作并不占用CPU，所以不要让所有的CPU闲下来，可以适当加大线程池中的线程数目，让CPU处理更多的业务
		 * 　　b）假如是业务时间长集中在计算操作上，也就是计算密集型任务，这个就没办法了，和（1）一样吧，线程池中的线程数设置得少一些，减少线程上下文的切换
		 *
		 * 并发高、业务执行时间长的业务 活动线程保持多一些 存活时间短一些
		 * 并发高、业务执行时间长，解决这种类型任务的关键不在于线程池而在于整体架构的设计，看看这些业务里面某些数据是否能做缓存是第一步，增加服务器是第二步，至于线程池的设置，
		 * 设置参考（2）。最后，业务执行时间长的问题，也可能需要分析一下，看看能不能使用中间件对任务进行拆分和解耦。
		 */
		for (int i = 0; i < 15; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
		             executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
		}
		
	}
}

/**
 * 自定义线程
 * @author Chan Kiang
 *
 */
class MyTask implements Runnable {

	private int taskNum;
	
	public MyTask(int num){
		this.taskNum = num;
	}
	
	@Override
	public void run() {
		System.out.println("正在执行task"+taskNum);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task"+taskNum+"执行完毕");
	}
	
}