package com.chuansen.system.senior.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 数组阻塞队列
 * ArrayBlockingQueue是一个由数组支持的有界的阻塞队列
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        //新建一个队列
        final BlockingQueue<String> blockingDeque = new ArrayBlockingQueue<String>(16);
        //4个线程
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String log = blockingDeque.take();
                            parselog(log);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        try {
            for (int i = 0; i < 16; i++) {
                String log = (i + 1) + "--> ";
                blockingDeque.put(log);   //将数据存到队列中
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void parselog(String log) {
        System.out.println(log +System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
