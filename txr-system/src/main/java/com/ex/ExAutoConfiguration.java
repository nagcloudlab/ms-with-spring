package com.ex;

import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@ConditionalOnJava(JavaVersion.SEVENTEEN)
//@ConditionalOnClass(value = {ExService.class})
//@ConditionalOnMissingClass(value = "com.ex.ExService")
//@ConditionalOnWebApplication
//@ConditionalOnMissingBean(name = "exService")
public class ExAutoConfiguration {

    @Bean
    @Profile(value = "qa")
    public ExService exService(){
        return new ExServiceImpl();
    }

}
