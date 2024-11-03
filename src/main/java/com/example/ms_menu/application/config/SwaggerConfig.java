package com.example.ms_menu.application.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
                .group("Menu")
                .pathsToMatch("/**")
                .displayName("Store Api")
                .build();
    }

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().version("1.0")
                .title("Menu Api")
                .description("Microservices Menu Api")
        );
    }
}
