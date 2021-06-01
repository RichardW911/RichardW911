public class Thread6 {
    public static void main(String[] args) {
        //lambda + 匿名runnable的实现方式
        Thread thread = new Thread(()->{
            System.out.println("线程名：" +Thread.currentThread().getName());
        });
        thread.start();
    }
}
