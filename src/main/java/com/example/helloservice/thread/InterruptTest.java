package com.example.helloservice.thread;

public class InterruptTest {

    public static void main(String[] args) {
        Thread aThread = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread bThread = new Thread(() -> {
            while (true) {
                //System.out.println("hello world");
            }
        });

        aThread.start();
        bThread.start();

        aThread.interrupt();
        bThread.interrupt();

        System.out.println(aThread.isInterrupted());
        System.out.println(bThread.isInterrupted());
    }
}
