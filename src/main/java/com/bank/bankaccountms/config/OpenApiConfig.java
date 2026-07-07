package com.bank.bankaccountms.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI bankAccountApi() {

        return new OpenAPI()
                .info(new Info()
                        .title("Bank Account Management API")
                        .description("REST API for managing bank accounts. Developed as a technical assessment using Spring Boot.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Joel Tercero")
                                .email("joel@correo.com")
                                .url("https://github.com/Joel"))
                        .license(new License()
                                .name("MIT License")));

    }

}
