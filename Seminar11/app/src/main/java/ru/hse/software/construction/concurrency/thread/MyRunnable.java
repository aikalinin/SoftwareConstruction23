package ru.hse.software.construction.concurrency.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName());
    }
}
