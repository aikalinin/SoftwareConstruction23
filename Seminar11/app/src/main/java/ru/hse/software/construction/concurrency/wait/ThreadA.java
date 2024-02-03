package ru.hse.software.construction.concurrency.wait;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import ru.hse.software.construction.concurrency.model.Player;

@Getter
@Setter
class ThreadA extends Thread {

    private int total;

    private Player player;

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(1000);
        synchronized (player) {
            // player.lock()
            System.out.println("ThreadA synchronized");

            for (int i = 0; i < 5; i++) {
                total += i;
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Notify calling");
            player.notifyAll();
            // player.unlock()
        }

        System.out.println(Thread.currentThread().getName() + " thread was terminated");
    }
}
