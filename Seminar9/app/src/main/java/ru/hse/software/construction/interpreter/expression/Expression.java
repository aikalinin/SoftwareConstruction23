package ru.hse.software.construction.interpreter.expression;

import ru.hse.software.construction.interpreter.Context;

public interface Expression {
    int interpret(Context context);
}
