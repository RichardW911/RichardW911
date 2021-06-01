public class Thread10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {

        },"张三");

        System.out.println("线程状态 " + t1.getState());
        t1.start();
        System.out.println("线程状态2 " + t1.getState());
        System.out.println("线程ID "+ t1.getId());
        System.out.println("线程名称 "+ t1.getName());
        System.out.println("线程优先级 "+ t1.getPriority());
        System.out.println("线程是否为后台线程 "+ t1.isDaemon());
        System.out.println("线程是否存活 " + t1.isAlive());
        System.out.println("线程被中断 " + t1.isInterrupted());
    }
}
