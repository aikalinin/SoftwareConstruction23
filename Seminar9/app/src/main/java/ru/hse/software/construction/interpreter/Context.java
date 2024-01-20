package ru.hse.software.construction.interpreter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;


public class Context {

    Map<String, Integer> variables = new LinkedHashMap<>();

    // получаем значение переменной по ее имени
    public Optional<Integer> getVariable(String name) {
        return Optional.ofNullable(variables.get(name));
    }

    public void setVariable(String name, int value) {
        variables.put(name, value);
    }

    public enum OperationType {
        SUM(Integer::sum),
        SUBSTRACT((lhv, rhv) -> lhv - rhv),
        MULTIPLY((lhv, rhv) -> lhv * rhv),
        DIVIDE((lhv, rhv) -> lhv / rhv);

        private final BiFunction<Integer, Integer, Integer> operation;

        OperationType(BiFunction<Integer, Integer, Integer> operation) {
            this.operation = operation;
        }

        public BiFunction<Integer, Integer, Integer> getOperation() {
            return operation;
        }
    }
}
