package com.example;

import com.ex.ExService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication
@PropertySource(value = "foo.properties")
public class TransferServiceApplication {

    public static void main(String[] args) {
        //----------------------------------------------
        // init / boot phase
        //----------------------------------------------

        ConfigurableApplicationContext applicationContext=
                SpringApplication.run(TransferServiceApplication.class,args);
        System.out.println("-".repeat(30));

//        ExService exService=applicationContext.getBean(ExService.class);
//        System.out.println(exService.getInfo());


    }


}
