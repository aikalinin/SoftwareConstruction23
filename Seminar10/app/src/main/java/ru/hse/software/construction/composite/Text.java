package ru.hse.software.construction.composite;

public class Text implements View {

    private boolean isHidden = false;

    @Override
    public void execute() {
        isHidden = true;
    }
}
