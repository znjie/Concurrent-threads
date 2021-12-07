package com.chuansen.system.senior.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个 Executor，它使用单个工作线程在无界队列中运行。
 * （但是请注意，如果这个单线程在关闭之前的执行过程中由于失败而终止，如果需要执行后续任务，一个新线程将取而代之。）保证任务按顺序执行，
 * 并且不会超过一个任务处于活动状态在任何给定的时间。
 * 与其他等效的newFixedThreadPool(1) ，返回的执行程序保证不可重新配置以使用其他线程。
 */
public class NewSingleThreadExecutorDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("into-->" + no);
                        Thread.sleep(1000l);
                        System.out.println("end-->" + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println("Thread Main End!");
    }
}
