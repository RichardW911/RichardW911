

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        //创建一个任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String data ="ABCD";
                for (char item:
                        data.toCharArray()) {
                    System.out.print(item);
                    try {
                        //休眠一段时间
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();

    }
}
