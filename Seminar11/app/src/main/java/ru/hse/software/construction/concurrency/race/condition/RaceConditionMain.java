package ru.hse.software.construction.concurrency.race.condition;

import java.util.stream.IntStream;

public class RaceConditionMain {

    public static void main(String[] args) {
        System.out.println(DumbCounter.class.getName());

//        for (int i = 0; i < 10; ++i) {
//            DumbCounter counter = new DumbCounter();
//
//            IntStream.range(0, 1000000).parallel().forEach(counter::increment);
//            System.out.println("Incorrect counter " + counter.getCount());
//        }

        for (int i = 0; i < 10; ++i) {
            AtomicDumbCounter counter = new AtomicDumbCounter();
            IntStream.range(0, 1000000).parallel().forEach(counter::increment);
            System.out.println("Correct counter " + counter.getCount());
        }
    }
}
