package ru.hse.software.construction.concurrency.executor.service;

import java.util.concurrent.*;

public class MainExecutorService {

    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        final ExecutorService executorService =
                new ThreadPoolExecutor(
                        1,
                        10,
                        0L,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>());


        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

//        List<Callable<String>> callableTasks = new ArrayList<>();
//        callableTasks.add(callableTask);
//        callableTasks.add(callableTask);
//        callableTasks.add(callableTask);

        System.out.println("Task will be submitted");

        executorService.execute(runnableTask);
        Future<String> future = executorService.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("Task was executed " + Thread.currentThread().getName());
            return "Task's execution";
        });

        System.out.println("Task was submitted");
        System.out.println(future.cancel(false));

        executorService.shutdown();

   /*     try {
            String result = executorService.invokeAny(callableTasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        try {
            List<Future<String>> futures = executorService.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
    }
}
