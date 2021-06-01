import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 实现Runnable接口方式
 */
public class Thread4 {
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("线程名：" +Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        //1.新建Runnable类
        MyRunnable myRunnable = new MyRunnable();
        //2.新建Thread
        Thread thread = new Thread(myRunnable);
        //3.启动线程
        thread.start();
    }
}
