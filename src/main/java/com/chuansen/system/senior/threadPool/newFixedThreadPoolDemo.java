package com.chuansen.system.senior.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个线程池，该线程池重用固定数量的线程在共享的无界队列中运行。
 * 在任何时候，最多有nThreads线程是活动的处理任务。
 * 如果在所有线程都处于活动状态时提交了额外的任务，它们将在队列中等待，直到有线程可用。
 * 如果任何线程在关闭前的执行过程中由于失败而终止，则在需要执行后续任务时，将有一个新线程代替它。 池中的线程将一直存在，直到它被明确shutdown
 */
public class newFixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("into-->" + no);
                        Thread.sleep(1000l);
                        System.out.println("end -->" + no);
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
