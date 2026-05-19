package com.example.MicroCliente.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;


@Configuration
public class FeignClientConfig {
    @Value("${ms.genero.user}")
    private String generoUser;

    @Value("${ms.genero.password}")
    private String generoPassword;

    @Bean
    public BasicAuthenticationInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthenticationInterceptor(generoUser, generoPassword);
    }
}
