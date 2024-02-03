package ru.hse.software.construction.template.method;

import ru.hse.software.construction.template.method.builder.ComputerBuilder;
import ru.hse.software.construction.template.method.builder.StandardComputerBuilder;

public class TemplateMethodMain {
    public static void main(String[] args) {
        final ComputerBuilder computerBuilder = new StandardComputerBuilder();
        computerBuilder.buildComputer();
    }
}
