package server.sopt.server.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CORSConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://sopkathon-client-opal.vercel.app/",
                        "https://sopkathon-client-taeseungs-projects.vercel.app/",
                        "https://sopkathon-client-git-main-taeseungs-projects.vercel.app/"
                        )
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }

}
