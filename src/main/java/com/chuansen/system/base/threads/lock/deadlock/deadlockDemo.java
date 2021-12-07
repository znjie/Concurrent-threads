package com.chuansen.system.base.threads.lock.deadlock;

/**
 * 模拟死锁
 * 程序死在这里  永远不会执行
 */
public class deadlockDemo {
    public static void main(String[] args) {
        Count count=new Count();
        User1 user1=new User1(count);
        user1.setName("线程用户1");
        user1.start();
        User2 user2=new User2(count);
        user2.setName("线程用户2");
        user2.start();
    }
}
