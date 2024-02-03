package ru.hse.software.construction.concurrency.wait;


import ru.hse.software.construction.concurrency.model.Player;

public class WaitMain {

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();

        Player player = Player.builder()
                .name("a")
                .currentGame("b")
                .rating(1)
                .build();

        Player player2 = Player.builder()
                .name("a")
                .currentGame("b")
                .rating(1)
                .build();

        threadA.setPlayer(player);
        threadA.start();

        new Thread(() -> {
            synchronized (player2) {
                // player2.lock()
                player2.setRating(100);
                try {
                    player2.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(player2.getRating());
                // player2.unlock()
            }
        }).start();

        synchronized (player) {
            System.out.println("Main lock");
            // player.lock()
            player.wait();

            synchronized (player2) {
                player2.notify();
            }
            // player.unlock()

            System.out.println("Main unlock");
        }

//        threadA.join();

        System.out.println(threadA.getTotal());
    }
}