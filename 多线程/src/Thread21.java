public class Thread21 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.incrment();
        counter.decrment();
        System.out.println("最终执行结果：" + counter.getCount());
    }
}
