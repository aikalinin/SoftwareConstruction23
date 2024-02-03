package ru.hse.software.construction.template.method.builder;

import lombok.RequiredArgsConstructor;
import ru.hse.software.construction.template.method.model.Computer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public abstract class ComputerBuilder {

    protected final List<String> motherboardSetupStatus = new ArrayList<>();
    protected final Map<String, String> computerParts = new HashMap<>();
    
    public final Computer buildComputer() {
        addMotherboard();
        setupMotherboard();
        addProcessor();
        return new Computer(computerParts);
    }

    public abstract void addMotherboard();
    public abstract void setupMotherboard();
    public abstract void addProcessor();
}