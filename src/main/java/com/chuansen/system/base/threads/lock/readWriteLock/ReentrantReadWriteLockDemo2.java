package com.chuansen.system.base.threads.lock.readWriteLock;

public class ReentrantReadWriteLockDemo2 {

    public static void main(String[] args) {
        final Count2 ct=new Count2();
        Object obj=ct.readWrite("2");
        System.out.println(obj);
    }

}
