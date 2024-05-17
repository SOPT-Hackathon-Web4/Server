package server.sopt.server.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("KREAM Swagger")
                .description("NOW SOPT 합동 세미나 모바일 앱 4팀 - 크림 Swagger dev API")
                .version("v1");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
