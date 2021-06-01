public class Thread16 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "上班");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "下班");
            }
        };

        Thread t1 = new Thread(runnable,"张三");
        t1.start();
        t1.join(12000);
        Thread t2 = new Thread(runnable,"李四");
        t2.start();
    }
}
