public class Thread22 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            counter.incrment();
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            counter.decrment();
        });

        t2.start();

        t1.join();
        t2.join();
        System.out.println(counter.getCount());
    }

}
