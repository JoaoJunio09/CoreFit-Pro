package br.com.joaojuniodev.corefitpro.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API REST RESTful by application CoreFit Pro")
                .version("1.0.0")
                .description("CoreFit Pro application and system REST RESTful API endpoints")
                .termsOfService("by João Junio - JJ dev").contact(new Contact().email("joaojunio818@gmail.com"))
                .license(new License().name("FinancePro")));
    }
}