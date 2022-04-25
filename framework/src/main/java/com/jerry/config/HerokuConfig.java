package com.jerry.config;

import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class HerokuConfig {

    @Bean
    public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer() {
        return clientConfigurationBuilder -> {
            if (clientConfigurationBuilder.build().isUseSsl()) {
                clientConfigurationBuilder.useSsl().disablePeerVerification();
            }
        };
    }
}