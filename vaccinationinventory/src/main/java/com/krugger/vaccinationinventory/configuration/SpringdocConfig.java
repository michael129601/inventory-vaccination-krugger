package com.krugger.vaccinationinventory.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SpringdocConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI().
                 info(this.info());
    }

    public Info info() {
        return new Info().title("Vaccination Inventory")
                .version("1.0.0")
                .description("Krugger Employee Vaccination Inventory Management");
    }

}