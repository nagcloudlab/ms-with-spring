package com.ex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExConfiguration {

    @Bean
    public ExService exService(){
        return new ExServiceImpl();
    }

}
