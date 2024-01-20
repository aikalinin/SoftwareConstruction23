package ru.hse.software.construction.interpreter.expression;

import lombok.RequiredArgsConstructor;
import ru.hse.software.construction.interpreter.Context;
import ru.hse.software.construction.interpreter.expression.Expression;

@RequiredArgsConstructor
public class AddExpression implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    @Override
    public int interpret(Context context) {
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}
