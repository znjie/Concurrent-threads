package com.chuansen.system.senior.queue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue是一个不存储元素的阻塞队列
 * 每一个put操作必须等待一个take操作，否则不能继续添加元素
 * 将程序改造成10个线程来消费生产者产生的数据，这些消费者都调用TestDo.doSome()方法去进行处理，
 * 故每个消费者都需要1秒才能处理完。
 */
public class SynchronousQueueDemo {


    public static void main(String[] args) {
        System.out.println("begin:" + System.currentTimeMillis() / 1000);
        //定义一个Synchronous
        final SynchronousQueue<String> sq = new SynchronousQueue<String>();
        //定义一个数量为1的信号量，其作用相当于一个互斥锁
        final Semaphore sem = new Semaphore(1);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sem.acquire();   //从此信号获取一个许可，在提供一个许可前一直将线程阻塞，否则线程被中断
                        String input = sq.take();  //获取线程
                        String output = TestDo.doSome(input);
                        System.out.println(Thread.currentThread().getName() + "-->" + output);
                        sem.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {   //这行不能动
            String input = i + "";   //这行不能动
            try {
                sq.put(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


//不改动此类
class TestDo {
    public static String doSome(String input) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input + ":" + (System.currentTimeMillis() / 1000);
        return output;
    }
}
