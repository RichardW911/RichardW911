import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Thread8 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始时间" + new Date());
        //休眠1s
        //方式1
        //Thread.sleep(1000);
        //方式2
        //TimeUnit.SECONDS.sleep(1);
        //方式3
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("休眠时间" + new Date());
    }
}
