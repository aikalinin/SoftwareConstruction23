package ru.hse.software.construction.chain.of.responsibility;

import ru.hse.software.construction.chain.of.responsibility.pocessor.AuthenticationProcessor;
import ru.hse.software.construction.chain.of.responsibility.pocessor.OAuthProcessor;
import ru.hse.software.construction.chain.of.responsibility.pocessor.UsernamePasswordProcessor;
import ru.hse.software.construction.chain.of.responsibility.provider.UsernamePasswordProvider;

public class СoRMain {

    public static void main(String[] args) {
        final UsernamePasswordProvider provider = new UsernamePasswordProvider();
        final AuthenticationProcessor processor = new OAuthProcessor(new UsernamePasswordProcessor(null));

        System.out.println(processor.isAuthorized(provider));
    }
}
