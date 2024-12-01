package com.tayssir.cosmetique;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.tayssir.cosmetique.entities.Classification;
import com.tayssir.cosmetique.entities.Cosmetique;

@Configuration
public class GlobalRepositoryRestConfigurer implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // Expose IDs for specified entities
        config.exposeIdsFor(Classification.class, Cosmetique.class);

        // Enable body in response for create/update
        config.setReturnBodyOnCreate(true);
        config.setReturnBodyOnUpdate(true);

        // Configure CORS
        cors.addMapping("/**")
            .allowedOrigins("*") // Update with your production domain when deploying
            .allowedHeaders("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
            .allowCredentials(true); // Add this if credentials are needed
    }
}
