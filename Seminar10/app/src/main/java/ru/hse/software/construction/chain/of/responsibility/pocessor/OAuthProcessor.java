package ru.hse.software.construction.chain.of.responsibility.pocessor;

import ru.hse.software.construction.chain.of.responsibility.provider.AuthenticationProvider;
import ru.hse.software.construction.chain.of.responsibility.provider.OAuthTokenProvider;

public class OAuthProcessor extends AuthenticationProcessor {

    public OAuthProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider authProvider) {
        if (authProvider instanceof OAuthTokenProvider) {
            return true;
        } else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProvider);
        }
        
        return false;
    }
}