import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//import java.lang.*;

/**
 * 创建并得到线程的执行结果
 * 实现Callable 接口 + Future 的方式
 */

public class Thread7 {
    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            //生成一个随机数
            int num = new  Random().nextInt(10);
            System.out.println("子线程" +Thread.currentThread().getName() +",随机数：" + num);
            return num;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        //2.创建一个FutrueTask 对象来接收返回值
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        //3.创建Thread
        Thread thread = new Thread(futureTask);

        //启动线程
        thread.start();
        //得到线程执行的结果
        int result = futureTask.get();
        System.out.println("线程名：" + Thread.currentThread().getName() + "随机数：" + result);
    }
}
