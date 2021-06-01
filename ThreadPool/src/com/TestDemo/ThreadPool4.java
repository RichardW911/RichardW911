package com.TestDemo;


import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//创建执行定时任务的线程池
public class ThreadPool4 {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(50);
        System.out.println("设置定时任务：" +new Date());
        /*
        参数1；线程执行的任务 Runnalbe
        参数2：推迟时间
        参数3：执行频率
        参数4：配合参数2和参数3使用的，它规定了时间的单位
        */

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程名：" + Thread.currentThread().getName() + "执行任务：" + new Date());
            }
        },1,3, TimeUnit.SECONDS);



        //只会执行一次
        /*scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务：" + new Date());
            }
        },1,TimeUnit.SECONDS);*/

/*        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程名：" + Thread.currentThread().getName() + "执行任务：" + new Date());
            }
        },1,3,TimeUnit.SECONDS);*/
    }
}
