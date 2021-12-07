package com.chuansen.system.application.monitor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的监控
 */
public class MonitorThreadPoolExecutorDemo {
    public static void main(String[] args) {
        try {
            Thread.sleep(500L);//方便测试
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ExecutorService executorService=new MonitorThreadPoolExecutor(5,5,0L, TimeUnit.MILLISECONDS,new LinkedBlockingDeque());
        for (int i = 0; i < 3; i++) {
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println("Thread Main End!!");
    }
}
