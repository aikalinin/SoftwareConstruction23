package ru.hse.software.construction.memento.caretaker;

import ru.hse.software.construction.memento.Memento;
import ru.hse.software.construction.memento.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerCaretaker implements Caretaker<Player> {

    public final List<Memento<Player>> mementoList = new ArrayList<>();

    public void add(Memento<Player> mementoState) {
        mementoList.add(mementoState);
    }

    public Memento<Player> get(int index) {
        return mementoList.get(index);
    }

    public Memento<Player> getLast() {
        return mementoList.get(mementoList.size() - 1);
    }

    public List<Memento<Player>> getAll() {
        return mementoList;
    }
}
