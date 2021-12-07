package com.chuansen.system.base.threads.lock.singleCase;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全，性能又高
 */
public class Singleton_4 {
    private static Singleton_4 instance;
    private static ReentrantLock lock=new ReentrantLock();

    public Singleton_4() {
    }

    public static Singleton_4 getInstance(){
        if (instance==null){
            lock.lock();
            if (instance==null){
                instance=new Singleton_4();
            }
            lock.unlock();
        }
        return instance;
    }
}
