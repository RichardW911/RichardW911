public class Counter {
    //私有变量 Count
    private int count = 0;

    //执行循环次数
    private static volatile int maxSize = 1000_0000;
    //执行1w次 1_0000
    public void incrment() {
        for (int i = 0; i < maxSize; i++) {
            count++;
        }
    }
    //执行1w次 -1_0000
    public void decrment() {
        for(int i = 0; i < maxSize; i++) {
            count--;
        }
    }



    //提供变量count的查询
    public int getCount() {
        return count;
    }
}
