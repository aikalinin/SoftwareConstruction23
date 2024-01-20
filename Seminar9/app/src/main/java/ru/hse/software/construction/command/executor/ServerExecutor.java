package ru.hse.software.construction.command.executor;

import lombok.RequiredArgsConstructor;
import ru.hse.software.construction.command.executor.Executor;
import ru.hse.software.construction.command.request.RequestService;

@RequiredArgsConstructor
public class ServerExecutor implements Executor {

    private final RequestService requestService;

    private final String url;

    @Override
    public void execute() {
        requestService.serverRequest(url);
    }
}
