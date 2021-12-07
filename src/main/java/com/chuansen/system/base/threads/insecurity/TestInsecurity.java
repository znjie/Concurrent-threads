package com.chuansen.system.base.threads.insecurity;

/**
 * 线程不安全   必须加在干活类        synchronized
 */
public class TestInsecurity {
    public static void main(String[] args) {
        Count count = new Count();
        for (int i = 0; i < 5; i++) {
            User user = new User(count);
            user.start();
        }
        try {
            Thread.sleep(1001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5个人干活：最后的值" + count.num);
    }
}
