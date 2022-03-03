package com.example.repository.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private GreetingProperties greetingProperties;

    public GreetingController(GreetingProperties greetingProperties) {
        this.greetingProperties = greetingProperties;
    }

//    @Value("${greeting.message: greetings}")
//    String message;
//
//    @Value("${greeting.messages}")
//    List<String> messages;
//
//    //SpEL
//    @Value("#{${greeting.locale.messages}}")
//    Map<String,String> localeMessages;


    @GetMapping("/api/greeting")
    public String doGreeting() {
        System.out.println(greetingProperties.getMessage());
        System.out.println(greetingProperties.getLocale());
        return greetingProperties.getMessage();
    }

}
