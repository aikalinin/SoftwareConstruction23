package ru.hse.software.construction.memento;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Memento<T> {
    private T state;
}
