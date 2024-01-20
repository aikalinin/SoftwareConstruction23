package ru.hse.software.construction.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class IteratorMain {

    public static void main(String[] args) {
        final List<String> iterableCollection = new ArrayList<>();

        iterableCollection.add("1");
        iterableCollection.add("2");
        iterableCollection.add("3");
        iterableCollection.add("4");

        forEach(iterableCollection, System.out::println);
    }

    private static <T> void forEach(Iterable<T> iterable, Consumer<T> consumer) {
        Iterator<T> iterator = iterable.iterator();

        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }
}
