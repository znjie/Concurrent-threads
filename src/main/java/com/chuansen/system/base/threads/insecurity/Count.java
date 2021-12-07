package com.chuansen.system.base.threads.insecurity;

/**
 * 干活类
 */
public class Count {
    public int num = 0;

    public synchronized void add() {
        try {
            Thread.sleep(51);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num += 1;
        System.out.println(Thread.currentThread().getName() + "-" + num);
    }
}
