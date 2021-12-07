package com.chuansen.system.base.impl;

public class CreatedRunnable {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();
        new Thread(threadB).start();
        System.out.println("这是主线程");
    }
}

class ThreadB implements Runnable {

    public void run() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程B");
    }
}
