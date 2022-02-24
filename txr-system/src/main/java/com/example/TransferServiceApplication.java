package com.example;

import com.example.config.TxrSystemConfiguration;
import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransferServiceApplication {
    public static void main(String[] args) {
        //----------------------------------------------
        // init / boot phase
        //----------------------------------------------

        /*

            => load bean-definition / component-scanning
            => BFPP
            => For Each bean definition

                - instantiation
                - dependency injection
                ----------OR------------------

                - calling @Bean methods

                ----------------------------
                 -> BPP

         */

        ConfigurableApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(TxrSystemConfiguration.class);
        System.out.println("-".repeat(30));
        //----------------------------------------------
        // Use
        //----------------------------------------------
        TransferService transferService=applicationContext.getBean(TransferService.class);
//        System.out.println(transferService.getClass());
        transferService.transfer(100.00,"1","2");
        System.out.println("-".repeat(30));
        //----------------------------------------------
        // destroy
        //----------------------------------------------
        //.....
        applicationContext.close();
    }
}
