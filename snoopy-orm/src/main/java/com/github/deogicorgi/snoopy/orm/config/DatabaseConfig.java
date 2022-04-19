package com.github.deogicorgi.snoopy.orm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.deogicorgi.snoopy.orm.repository")
public class DatabaseConfig {

}
