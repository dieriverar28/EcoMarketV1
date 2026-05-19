package com.example.MicroCliente.client;

import com.example.MicroCliente.dto.GeneroDTO;
import com.example.MicroCliente.model.*;

import org.springframework.boot.web.servlet.FilterRegistration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "ms-genero",
    url = "${ms.genero.url}",
    configuration = FeignClientConfig.class
)

public interface GeneroClient {
 /**
     * Llama a GET http://localhost:8081/api/generos/{id}
     * Si el género no existe, Feign lanza FeignException que manejamos en el servicio.
     */
    @GetMapping("/api/generos/{id}")
    GeneroDTO buscarPorId(@PathVariable("id") Long id);

}
