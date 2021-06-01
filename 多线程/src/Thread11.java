public class Thread11 {
    public static void main(String[] args) {


        Thread thread = new Thread(() -> {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
            System.out.println("t1 守护线程：" + t1.isDaemon());
        });
        //System.out.println("Thread 守护线程：" + thread.isDaemon());
        thread.setDaemon(true);
        thread.start();
        System.out.println("Thread 守护线程：" + thread.isDaemon());
    }
}
