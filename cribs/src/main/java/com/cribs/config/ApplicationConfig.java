package com.cribs.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.cribs.entity")
@EnableJpaRepositories(basePackages = "com.cribs.repo")
public class ApplicationConfig {
    
}
