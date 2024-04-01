package com.libraryManagement.config;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public String[] getString(){
        return new String[10];
    }
}
