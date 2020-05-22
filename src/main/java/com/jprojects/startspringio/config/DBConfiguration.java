package com.jprojects.startspringio.config;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDBConnection() {
        System.out.println("DB connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to H2_DEV - Instance Development";
    }

    @Profile("prod")
    @Bean
    public String prodDBConnection() {
        System.out.println("DB connection for PROD - MYSQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB Connection to MYSQL_PROD - Instance Production";
    }
}
