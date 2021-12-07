package com.chuansen.system.base.threads.lock.singleCase;

/**
 * 线程不安全
 */
public class Singleton_1 {
    private static Singleton_1 instance;

    public Singleton_1() {
    }

    public static Singleton_1 getInstance() {
        if (instance == null) {
            instance = new Singleton_1();
        }
        return instance;
    }
}
