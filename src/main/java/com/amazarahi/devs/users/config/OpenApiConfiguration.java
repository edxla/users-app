package com.amazarahi.devs.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("API de Desarrollo")
                .description("API para crear un App Restfull")
                .version("2.0")
                .contact(apiContact())
                .license(apiLicence());
    }
    
    private License apiLicence() {
        return new License()
                .name("GNU")
                .url("https://www.gnu.org/licenses/licenses.es.html");
    }

    private Contact apiContact() {
        return new Contact()
                .name("Edxla")
                .email("edxla@gmail.com")
                .url("https://github.com/edxla/edxla");
    }
    
}