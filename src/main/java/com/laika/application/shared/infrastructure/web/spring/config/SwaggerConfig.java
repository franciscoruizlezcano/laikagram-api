package com.laika.application.shared.infrastructure.web.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInformation(){
        return new ApiInfo("Monolith Clean Architecture REST API",
                "This is a Monolith Clean Architecture API created using Spring Boot",
                "1.0",
                "https://github.com/franciscoruizlezcano/monolith-clean-architecture",
                new Contact("Francisco Ruiz", "www.laikacode.com", "franciscoruizlezcano@gmail.com"),
                "API License",
                "API License URL",
                Collections.emptyList()
        );
    }
}