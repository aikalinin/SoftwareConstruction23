package ru.hse.software.construction.interpreter.expression;

import lombok.RequiredArgsConstructor;
import ru.hse.software.construction.interpreter.Context;
import ru.hse.software.construction.interpreter.expression.Expression;

import java.text.MessageFormat;

@RequiredArgsConstructor
public class NumberExpression implements Expression {

    private final String name;

    @Override
    public int interpret(Context context) {
        return context
                .getVariable(name)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException(
                            MessageFormat.format(
                                    "Context doesn''t have variable {0} {1}.",
                                    name
                            ));
                });
    }
}
