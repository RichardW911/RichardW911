package com.TestDemo;

import java.util.concurrent.Callable;

public class ThreadDemo13 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runn(), "t1");

        t.start();

    }
}


class Call implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}

class Runn implements Runnable {
    @Override
    public void run() {
        System.out.println("go....");
    }
}