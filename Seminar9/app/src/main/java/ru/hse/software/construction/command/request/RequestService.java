package ru.hse.software.construction.command.request;

public interface RequestService {

    void cacheRequest(String url, String username, String password);

    void serverRequest(String url);
}
