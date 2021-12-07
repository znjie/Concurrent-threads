package com.chuansen.system.base.threads.lock.deadlock;

/**
 * 死锁案例
 */
public class Count {
    private byte[] lock1 = new byte[1];
    private byte[] lock2 = new byte[1];
    public int num = 0;

    public void add() {
        synchronized (lock1) {
            try {
                Thread.sleep(1001); //模仿用户干活
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2) {//产生死锁等待lock2对象释放锁
                num += 1;
            }
            System.out.println(Thread.currentThread().getName() + "-" + num);

        }
    }

    public void lockMethod() {
        synchronized (lock2) {  //锁的对象不一样
            try {
                Thread.sleep(1001); //模仿用户干活
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {//产生死锁等待lock1对象释放锁
                num += 1;
            }
            System.out.println(Thread.currentThread().getName() + "-" + num);

        }
    }

}
