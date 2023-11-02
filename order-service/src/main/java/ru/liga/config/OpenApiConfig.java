package ru.liga.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi -> {
            Info info = new Info();
            info.title("Название схемы");
            openApi.info(info);
            openApi.addSecurityItem(new SecurityRequirement().addList("Защищенная схема"));
            openApi.getComponents().addSecuritySchemes("Защищенная схема 1 ",
                    new SecurityScheme()
                            .name("bearerAuth")
                            .bearerFormat("JWT")
                            .type(SecurityScheme.Type.OAUTH2));
        };
    }
}