package ru.hse.software.construction.interpreter;

import ru.hse.software.construction.interpreter.expression.Expression;
import ru.hse.software.construction.interpreter.expression.NumberExpression;
import ru.hse.software.construction.interpreter.expression.OperationExpression;
import ru.hse.software.construction.interpreter.expression.SubtractExpression;

public class InterpreterMain {
    public static void main(String[] args) {
        final Context context = new Context();

        int x = 5;
        int y = 8;
        int z = 2;

        context.setVariable("x", x);
        context.setVariable("y", y);
        context.setVariable("z", z);

        // ((x + y) - z) * y
        //   operation(multiply)
        //     /   \
        //    sub   y
        //  /    \
        //  add  z
        // /  \
        // x  y
        final Expression expression =
                new OperationExpression(
                        Context.OperationType.MULTIPLY,
                        new SubtractExpression(
                                new OperationExpression(
                                        Context.OperationType.SUM,
                                        new NumberExpression("x"),
                                        new NumberExpression("y")
                                ),
                                new NumberExpression("z")
                        ),
                        new NumberExpression("y")
                );

        final int result = expression.interpret(context);

        System.out.println("Result: " + result);
    }
}
