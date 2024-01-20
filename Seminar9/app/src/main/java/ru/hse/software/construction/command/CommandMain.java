package ru.hse.software.construction.command;

import ru.hse.software.construction.command.executor.DatabaseExecutor;
import ru.hse.software.construction.command.executor.ServerExecutor;
import ru.hse.software.construction.command.request.RemoteRequestService;
import ru.hse.software.construction.command.request.RequestService;

public class CommandMain {
    public static void main(String[] args) {
        final ExecutorHandler executorHandler = new ExecutorHandler();
        final RequestService requestService = new RemoteRequestService();

        executorHandler.addExecutor(
                ExecutorHandler.ExecutorName.DATABASE,
                new DatabaseExecutor(
                        requestService,
                        "jdbc://databse",
                        "Anton",
                        "password"
                )
        );

        executorHandler.addExecutor(
                ExecutorHandler.ExecutorName.SERVER,
                new ServerExecutor(
                        requestService,
                        "https://remote.com"
                )
        );

        final ExecutorHandler executorHandler2 = new ExecutorHandler();

        executorHandler2.addExecutor(
                ExecutorHandler.ExecutorName.DATABASE,
                new DatabaseExecutor(
                        requestService,
                        "jdbc://databse",
                        "Anton",
                        "password"
                )
        );

        executorHandler2.addExecutor(
                ExecutorHandler.ExecutorName.SERVER,
                new ServerExecutor(
                        requestService,
                        "https://remote.com"
                )
        );

        executorHandler.executeByName(ExecutorHandler.ExecutorName.DATABASE);
        executorHandler.executeByName(ExecutorHandler.ExecutorName.SERVER);
        executorHandler.executeAll();

        System.out.println("executorHandler == executorHandler2 -> " + (executorHandler == executorHandler2));

        Integer firstValue = 255;
        Integer secondValue = 255;

        System.out.println("firstValue == secondValue -> " + (firstValue == secondValue));
        System.out.println("firstValue equals secondValue -> " + (firstValue.equals(secondValue)));

        Integer firstValue2 = -128;
        Integer secondValue2 = -128;

        System.out.println("firstValue2 == secondValue2 -> " + (firstValue2 == secondValue2));
        System.out.println("firstValue2 equals secondValue2 -> " + (firstValue2.equals(secondValue2)));

        String str1 = "str";
        String str2 = "str";
        String str3 = str1 + str2;
        String str4 = "strstr";

        System.out.println("str1 == str2 -> " + (str1 == str2));
        System.out.println("str3 == str4 -> " + (str3 == str4));
        System.out.println("str3 equals str4 -> " + (str3.equals(str4)));
        System.out.println(Messages.SMTH);
    }
}

class Messages {
    private Messages() {}
    public static final String SMTH = "smth";
}
