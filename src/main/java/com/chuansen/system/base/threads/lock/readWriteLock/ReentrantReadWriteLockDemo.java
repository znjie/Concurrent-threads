package com.chuansen.system.base.threads.lock.readWriteLock;

/**
 * 结果显示  读的时候是并发的  写的时候是有顺序的带阻塞机制的
 */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        final Count ct=new Count();
        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    ct.get();
                }
            }.start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                   ct.put();
                }
            }.start();
        }
    }
}
