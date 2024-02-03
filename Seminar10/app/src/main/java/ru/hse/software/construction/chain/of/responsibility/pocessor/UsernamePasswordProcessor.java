package ru.hse.software.construction.chain.of.responsibility.pocessor;

import ru.hse.software.construction.chain.of.responsibility.provider.AuthenticationProvider;
import ru.hse.software.construction.chain.of.responsibility.provider.UsernamePasswordProvider;

public class UsernamePasswordProcessor extends AuthenticationProcessor {

    public UsernamePasswordProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider authProvider) {
        if (authProvider instanceof UsernamePasswordProvider) {
            return true;
        } else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProvider);
        }

        return false;
    }
}