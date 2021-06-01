import com.sun.deploy.net.proxy.ProxyUnavailableException;

public class Thread1 {

    //执行的循环次数
    private static final long count = 10_0000_0000;
    public static void main(String[] args) throws InterruptedException {

        //调用多线程的方法
        concorrency();
        dan();

    }



    //多线程的方法
    private static void concorrency() throws InterruptedException {
        //开始时间
        Long stime = System.currentTimeMillis();
        //todo:执行30亿次循环
        java.lang.Thread t1 = new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(long i = 0; i < count; i++) {
                    a++;
                }
            }
        });
        t1.start();

        java.lang.Thread t2 = new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                int b = 0;
                for(long i = 0; i < count; i++) {
                    b++;
                }
            }
        });
        t2.start();
        java.lang.Thread t3 = new java.lang.Thread(new Runnable() {
            @Override
            public void run() {
                int c = 0;
                for(long i = 0; i < count; i++) {
                    c++;
                }
            }
        });

        //等待线程t1 和 t2 执行完成之后，才统计时间
        t1.join();
        t2.join();

        //结束时间
        Long etime = System.currentTimeMillis();
        System.out.println("多线程执行了:" + (etime - stime) );
    }

    private static void dan() {
        Long stime = System.currentTimeMillis();
        int x = 0;
        for(long i = 0; i < count; i++) {
            x++;
        }
        Long etime = System.currentTimeMillis();
        System.out.println("单线程执行了:" + (etime - stime) );
    }
}
