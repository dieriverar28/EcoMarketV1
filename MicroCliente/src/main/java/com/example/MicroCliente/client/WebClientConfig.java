package com.example.MicroCliente.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Base64;

@Configuration
public class WebClientConfig {
    @Value("${ms.genero.url}")
    private String generoUrl;

    @Value("${ms.genero.user}")
    private String generoUser;

    @Value("${ms.genero.password}")
    private String generoPassword;

    @Bean
    public WebClientConfig generoWebClient() {
        // Construimos el header Basic Auth manualmente:
        // Base64(usuario:contraseña)
        String credenciales = generoUser + ":" + generoPassword;
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(credenciales.getBytes());

        return ((Object) WebClientConfig.builder())
                        .baseUrl(generoUrl)
                        // defaultHeader: se envia en TODAS las peticiones de este WebClient
                        .defaultHeader("Authorization", basicAuth)
                        .build();
            }
        
            
}
