public class Thread3 {
    public static void main(String[] args) {
        Thread thread = new java.lang.Thread() {
            @Override
            public void run() {
                System.out.println("线程名：" +Thread.currentThread().getName());
            }
        };
        thread.start();
    }
}
