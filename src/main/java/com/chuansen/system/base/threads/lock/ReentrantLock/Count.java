package com.chuansen.system.base.threads.lock.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 第一种情况  导致每次结果不一样
 * 第二种情况  ReentrantLock改为全局变量  结果是按有顺序的输出
 */
public class Count {
    final ReentrantLock lock = new ReentrantLock();   //第二种情况
    public void get() {
       // final ReentrantLock lock = new ReentrantLock();   //第一种情况
        try {
            lock.lock();//加锁
            System.out.println(Thread.currentThread().getName() + "get begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "get end");
            lock.unlock();//解锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void put() {
      //  final ReentrantLock lock = new ReentrantLock();   //第一种情况
        try {
            lock.lock();//加锁
            System.out.println(Thread.currentThread().getName() + "put begin");
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + "put end");
            lock.unlock();//解锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
