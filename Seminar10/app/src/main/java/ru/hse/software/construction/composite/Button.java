package ru.hse.software.construction.composite;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class Button implements View {

    private final Collection<View> innersViews;

    private final Consumer action; // пустая лямбда

    @Override
    public void execute() {
        action.accept(new Object());
        innersViews.forEach(View::execute);
    }
}
