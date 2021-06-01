public class Thread18 {
    public static void main(String[] args) throws InterruptedException {
        //Object obj = new Object();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
        });
        System.out.println("执行之前" + t1.getState());

        t1.start();

        System.out.println("执行之后" + t1.getState());

        Thread.sleep(100);

        System.out.println("休眠了100ms之后的状态" + t1.getState());

        //等待执行完成
        t1.join(); //实现方式1

        System.out.println("线程最终状态" + t1.getState());
    }
}
