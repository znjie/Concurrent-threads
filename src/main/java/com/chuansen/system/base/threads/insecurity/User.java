package com.chuansen.system.base.threads.insecurity;

/**
 * 用户类  干活
 */
public class User extends Thread {
    private Count count;

    public User(Count count) {
        this.count = count;
    }

    public void run() {
        count.add();
    }

}
