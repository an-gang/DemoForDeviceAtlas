package com.gangan.demofordeviceatlas.framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class ApplicationConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setMaxAge(3600L); // set pre cors request cache time on browser
        corsConfiguration.addAllowedOrigin("*"); // allow all origin ip
        corsConfiguration.addAllowedMethod("*"); // allow all http method
        corsConfiguration.addAllowedHeader("*"); // allow all header
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // effect all requirement

        return new CorsFilter(source);
    }
}
