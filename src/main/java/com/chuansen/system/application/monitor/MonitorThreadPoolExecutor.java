package com.chuansen.system.application.monitor;

import java.util.concurrent.*;

public class MonitorThreadPoolExecutor extends ThreadPoolExecutor {
    public MonitorThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("work_task before : " + t.getName());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        System.out.println("work_task after worker thread is : " + r);
    }

    /**
     * getCorePoolSize：线程池的数量
     * getTaskCount：线程池需要执行的任务数量
     * getCompletedTaskCount：线程池在运行过程中已完成的任务数量
     * getLargestPoolSize：线程池曾经创建过的最大线程数量
     * getActiveCount：获取活动的线程数
     */
    protected void terminated(){
        System.out.println(
                "线程池的数量 : "+this.getCorePoolSize() +"     : 线程池的工作的数量 :"+ this.getPoolSize() +"       ： 线程池需要执行的任务数量: "+this.getTaskCount()
        +": 线程池在运行过程中已完成的任务数量 : "+ this.getCompletedTaskCount() + ": 线程池曾经创建过的最大线程数量:"+this.getLargestPoolSize()+": 获取活动的线程数:"+this.getActiveCount()
        );
    }
}
