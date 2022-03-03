package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class GreetingController {

    private GreetingProperties greetingProperties;

    public GreetingController(GreetingProperties greetingProperties) {
        this.greetingProperties = greetingProperties;
    }

    @Autowired
    private Environment environment;

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
        System.out.println(Arrays.stream(environment.getActiveProfiles()).collect(Collectors.joining(",")));
        System.out.println(environment.getProperty("greeting.user"));
        return greetingProperties.getMessage();
    }

}
