package ru.hse.software.construction.interpreter.expression;

import lombok.RequiredArgsConstructor;
import ru.hse.software.construction.interpreter.Context;
import ru.hse.software.construction.interpreter.expression.Expression;

@RequiredArgsConstructor
public class SubtractExpression implements ru.hse.software.construction.interpreter.expression.Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public int interpret(Context context) {
        return leftExpression.interpret(context) - rightExpression.interpret(context);
    }
}
