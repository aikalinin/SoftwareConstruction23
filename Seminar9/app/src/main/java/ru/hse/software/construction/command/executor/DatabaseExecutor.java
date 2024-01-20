package ru.hse.software.construction.command.executor;

import lombok.RequiredArgsConstructor;
import ru.hse.software.construction.command.executor.Executor;
import ru.hse.software.construction.command.request.RequestService;

@RequiredArgsConstructor
public class DatabaseExecutor implements Executor {

    private final RequestService requestService;

    private final String url;

    private final String username;

    private final String password;

    @Override
    public void execute() {
        requestService.cacheRequest(url, username, password);
    }
}
