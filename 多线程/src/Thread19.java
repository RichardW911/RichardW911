public class Thread19 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                //出让 cpu 执行权
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.yield();
                System.out.println("我是线程1");
            }
        });
        t1.start();



        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("我是线程2");
            }
        });
        t2.start();
    }
}
