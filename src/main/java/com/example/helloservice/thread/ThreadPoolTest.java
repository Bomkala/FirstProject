package com.example.helloservice.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    static int i = 0;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1L, TimeUnit.NANOSECONDS, new ArrayBlockingQueue<Runnable>(10000));


        while (i < 1000) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("hello world" + i++);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }



            });
        }
        executor.shutdownNow();
    }
}