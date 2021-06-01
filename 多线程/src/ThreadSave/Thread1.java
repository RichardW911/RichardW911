package ThreadSave;

import sun.misc.Lock;

import java.util.concurrent.SynchronousQueue;

public class Thread1 {

    private static volatile int maxSize = 1000_0000;
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    synchronized (lock) {
                        count++;
                    }

                }
            }
        });t1.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < maxSize; i++) {
                    synchronized (lock){
                        count--;
                    }

                }
            }
        });
        t2.start();


        t1.join();
        t2.join();

        System.out.println(count);
    }
}
