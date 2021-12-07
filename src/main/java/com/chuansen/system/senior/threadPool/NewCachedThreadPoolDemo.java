package com.chuansen.system.senior.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个线程池，根据需要创建新线程，但在可用时将重用先前构造的线程。 这些池通常会提高执行许多短期异步任务的程序的性能。
 * 如果可用，调用execute将重用先前构造的线程。 如果没有可用的现有线程，则会创建一个新线程并将其添加到池中。
 * 60秒内未使用的线程将被终止并从缓存中删除。 因此，保持空闲足够长时间的池不会消耗任何资源
 */
public class NewCachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("into -->" + no);
                        Thread.sleep(1000L);
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
