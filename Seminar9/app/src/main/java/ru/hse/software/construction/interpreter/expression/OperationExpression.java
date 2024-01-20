package ru.hse.software.construction.interpreter.expression;

import lombok.RequiredArgsConstructor;
import ru.hse.software.construction.interpreter.Context;

@RequiredArgsConstructor
public class OperationExpression implements Expression {

    private final Context.OperationType operationType;
    private final Expression leftExpression;
    private final Expression rightExpression;

    @Override
    public int interpret(Context context) {
        return operationType.getOperation()
                .apply(
                        leftExpression.interpret(context),
                        rightExpression.interpret(context)
                );
    }
}
