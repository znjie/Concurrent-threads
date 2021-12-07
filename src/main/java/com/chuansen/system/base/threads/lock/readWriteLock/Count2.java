package com.chuansen.system.base.threads.lock.readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 复杂模拟一个读写场景
 */
public class Count2 {

    private final Map<String, Object> map = new HashMap<String, Object>();  //假设这里面存了数据缓存

    private final ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

    public Object readWrite(String id) {
        Object value = null;
        rw.readLock().lock();  //首先开启读锁，从缓存中取
        try {
            value = map.get(id);
            if (value == null) {    //如果缓存中没有释放读锁，上写锁
                rw.readLock().unlock();  //释放读锁
                rw.writeLock().lock();  //开启写锁
                try {
                    if (value == null) {
                        value = "xxxxxxxxxx";  //可以从数据库去，这里只是模拟一下
                    }
                } finally {
                    rw.writeLock().unlock();//释放写锁
                }
                rw.readLock().lock();  //然后再上读锁
            }
        } finally {
            rw.readLock().unlock();//最后释放读锁
        }
        return value;
    }
}
