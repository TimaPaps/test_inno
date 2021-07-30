package ru.ptv.rest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 30.07.2021 - 17:40
 * PTV_Rest
 *
 * @author Papsuev Timofey
 * @version v1.0
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("PTV_Rest API")
                        .version("1.0.0")
                        .contact(new Contact()
                                .email("tima_papsuev@mail.ru")
                                .name("Papsuev Timofey")
                        )
                );
    }
}
