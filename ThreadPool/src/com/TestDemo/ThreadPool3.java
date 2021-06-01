package com.TestDemo;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPool3 {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new MyThreadFactory();
        ExecutorService executorService = Executors.newFixedThreadPool(10,threadFactory);
        for(int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    System.out.println("线程名：" + thread.getName() + "优先级：" + thread.getPriority());
                }
            });
        }
    }


    private static int count = 1;
    static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("mypool-" + count++);
            //设置线程池优先级规则
            thread.setPriority(10);
            return thread;
        }
    }

}
