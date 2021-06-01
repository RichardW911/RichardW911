
/**
 * 创建方法1：继承Thread类 (2、3、4)
 *
*/
public class Thread2 {
    static class MyThread extends Thread {
        @Override
        public void run() {
            //线程执行任务
            System.out.println("线程名称："+ Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
        System.out.println("当前线程名称（主线程）：" + Thread.currentThread().getName());
    }
}
