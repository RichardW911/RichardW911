import java.util.Random;

/**
 * 线程分组
 */
public class Thread9 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始起跑了" + Thread.currentThread().getName());
                int num = 1 + new Random().nextInt(5);
                try {
                    Thread.sleep(num*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我到终点了：" + Thread.currentThread().getName());
            }
        };
        //定义分组
        ThreadGroup group = new ThreadGroup("百米赛跑第一组");

        //创建运动员
        Thread t1 =new Thread(group,runnable,"王睿杰");
        Thread t2 = new Thread(group,runnable,"***");

        t1.start();
        t2.start();

        while(group.activeCount() != 0) {
        }

        //宣布成绩
        System.out.println("宣布成绩");
    }
}
