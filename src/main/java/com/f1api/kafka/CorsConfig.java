package com.f1api.kafka;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Permitir peticiones desde cualquier origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization") // Cabeceras permitidas
                .allowCredentials(false) // Permitir el envío de credenciales (por ejemplo, cookies)
                .maxAge(3600); // Tiempo máximo de cacheo de las configuraciones preflight
    }
}

