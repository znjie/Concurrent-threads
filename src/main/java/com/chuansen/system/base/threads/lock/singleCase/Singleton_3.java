package com.chuansen.system.base.threads.lock.singleCase;

/**
 * 线程安全，性能又高
 */
public class Singleton_3 {
    private static Singleton_3 instance;
    private static byte[] lock=new byte[0];

    private Singleton_3() {
    }

    public static Singleton_3 getInstance(){
        if (instance==null){
            synchronized (lock){
                if (instance==null){
                    instance=new Singleton_3();
                }
            }
        }
        return instance;
    }
}
