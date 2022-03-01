package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration()
@ComponentScan(basePackages = {"com.example"})
public class TransferServiceApplication {

    public static void main(String[] args) {
        //----------------------------------------------
        // init / boot phase
        //----------------------------------------------

        ConfigurableApplicationContext applicationContext=
                SpringApplication.run(TransferServiceApplication.class,args);
        System.out.println("-".repeat(30));
        //----------------------------------------------
        // Use
        //----------------------------------------------
//        TransferService transferService=applicationContext.getBean(TransferService.class);
////        System.out.println(transferService.getClass());
//        transferService.transfer(100.00,"1","2");
//        System.out.println("-".repeat(30));
        //----------------------------------------------
        // destroy
        //----------------------------------------------
        //.....
//        applicationContext.close();
    }


}
