package ru.hse.software.construction.chain.of.responsibility.pocessor;

import lombok.RequiredArgsConstructor;
import ru.hse.software.construction.chain.of.responsibility.provider.AuthenticationProvider;

@RequiredArgsConstructor
public abstract class AuthenticationProcessor {

    public final AuthenticationProcessor nextProcessor; // Лучше обернуть в optional

    public abstract boolean isAuthorized(AuthenticationProvider authProvider);
}