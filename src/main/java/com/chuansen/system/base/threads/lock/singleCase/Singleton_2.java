package com.chuansen.system.base.threads.lock.singleCase;

/**
 * 线程安全性，但高并发性能不是很高的写法
 */
public class Singleton_2 {
    private static Singleton_2 instance;

    public Singleton_2() {
    }

    public static synchronized Singleton_2 getInstance() {
        if (instance == null) {
            instance = new Singleton_2();
        }
        return instance;
    }
}
