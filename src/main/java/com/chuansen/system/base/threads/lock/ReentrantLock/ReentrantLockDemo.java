package com.chuansen.system.base.threads.lock.ReentrantLock;


/**
 * 显示锁
 * 需要手动开锁解锁
 */
public class ReentrantLockDemo {
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
