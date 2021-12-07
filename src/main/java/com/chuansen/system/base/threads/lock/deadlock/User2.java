package com.chuansen.system.base.threads.lock.deadlock;

public class User2 extends Thread{

    private Count count;

    public User2(Count count){
        this.count=count;
    }

    @Override
    public void run() {
        count.add();
    }
}
