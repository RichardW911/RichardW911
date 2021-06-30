package com.TestDemo;

/**
* 懒汉加载
*/
public class ThreadSingleleton {

    //饿汉模式
/*    static class Singleton {
        //1.将构造方法设置成私有的
        private Singleton() {}
        //2.创建一个静态的类变量
        private static final Singleton singleton = new Singleton();
        //3.给外部提供获取单例的方法
        public static Singleton getInstance() {
            return singleton;
        }
    }*/


    //懒汉模式
    static class Singleton {
        //1.无参构造方法
        private Singleton() {}
        //2.创建静态的类变量 用于返回参数
        private static volatile Singleton singleton = null;
        //3.给外部提供获取单例的方法
        public static Singleton getInstance() {
            if(singleton == null) {
                synchronized (Singleton.class) {
                    if(singleton == null) {
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }


    static Singleton s1 = null;
    static Singleton s2 = null;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                s1 = Singleton.getInstance();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                s2 = Singleton.getInstance();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(s1 == s2);
    }
}
