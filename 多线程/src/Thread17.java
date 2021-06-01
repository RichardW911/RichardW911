public class Thread17 {
    public static void main(String[] args) {
        for(Thread.State state:Thread.State.values()) {
            System.out.println(state);
        }
    }
}
/**
 * NEW      创建了线程单还没有开始工作
 * RUNNABLE     运行
 * BLOCKED      阻塞
 * WAITING      等待
 * TIMED_WAITING        超市等待，有具体等待时间
 * TERMINATED       终止
 */