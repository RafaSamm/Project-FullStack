package br.com.rhssolutions.Monolithic.project.FullStack.with.CRUD.controller.doc;


import io.swagger.v3.oas.annotations.OpenAPI31;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
                .title("CRUD API WITH ANGULAR FRONT")
                .description("Monolithic Project and register of people")
                .version("1.0.0")
                .contact(new Contact()
                        .name("RHSSolutions - Software Innovation and Quality")
                        .email("rhssolutions@gmail.com")
                        .url("https://www.rhssolutions.com.br"))).servers(List.of(
                new Server()
                        .url("http://localhost:8080")
                        .description("Local Server")
        ));
    }
}
