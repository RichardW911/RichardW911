import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class DeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T1正在加锁");
                while(true) {
                    synchronized(lock1) {
                        System.out.println("T1占有lock1");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock2) {
                            System.out.println("T1占有lock2");
                        }
                    }
                }
            }
        });

        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T1正在加锁");
                while(true) {
                    synchronized(lock2) {
                        System.out.println("T2占有lock2");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock1) {
                            System.out.println("T2占有lock1");
                        }
                    }
                }
            }
        });

        T1.start();
        T2.start();
    }

}
