package ru.hse.software.construction.composite;

import java.util.ArrayList;

public class CompositeMain {

    public static void main(String[] args) {

        Button button = new Button(
                new ArrayList<>() {{
                    add(new Text());
                    add(new Text());
                    add(new Text());
                }},
                (o) -> {
                    System.out.println("Button was pressed");
                });
    }
}
