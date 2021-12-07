package com.chuansen.system.base.threads.lock.readWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Count {
    private final ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

    public void get() {
        rw.readLock().lock();//上读锁，其他线程只能读不能写
        System.out.println(Thread.currentThread().getName() + " read.start");
        try {
            Thread.sleep(1000L);  //模拟干活
            System.out.println(Thread.currentThread().getName() + " read.end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rw.readLock().unlock();  //释放
        }
    }

    public void put() {
        rw.writeLock().lock();//上写锁，具有阻塞性
        System.out.println(Thread.currentThread().getName() + " write.start");
        try {
            Thread.sleep(1000L);  //模拟干活
            System.out.println(Thread.currentThread().getName() + " write.end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rw.writeLock().unlock();  //释放
        }
    }

}
