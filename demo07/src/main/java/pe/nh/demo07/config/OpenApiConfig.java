package pe.nh.demo07.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI().info(new Info()
                    .title("API de Productos - Sesion 7")
                    .version("v1")
                    .description("""
                        CRUD REST de demostracion con SpringBoot y Java.
                        Incluye DTOs (records), validacion con Bean Validation,
                        meanjeo global de errores y paginacion con Pageable/Page.
                    """)
                );
    }
    
}
