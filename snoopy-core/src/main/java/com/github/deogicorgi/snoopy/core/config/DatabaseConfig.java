package com.github.deogicorgi.snoopy.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.deogicorgi.snoopy.core.orm.repository")
public class DatabaseConfig {

    public DatabaseConfig(){
    }

}
