package com.chuansen.system.base.threads.lock.deadlock;

public class User1 extends Thread {
    private Count count;

    public User1(Count count){
        this.count=count;
    }

    @Override
    public void run() {
        count.lockMethod();
    }
}
