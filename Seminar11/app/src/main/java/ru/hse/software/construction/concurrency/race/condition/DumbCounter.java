package ru.hse.software.construction.concurrency.race.condition;

import lombok.Getter;

@Getter
class DumbCounter {
    private int count;
    public void increment(int v){
        count++;
    }
}
