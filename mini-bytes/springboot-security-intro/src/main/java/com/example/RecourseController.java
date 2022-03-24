package com.example;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecourseController {

    @GetMapping("/api/public")
    public String publicResource(){
        return "public-resource";
    }

    @GetMapping("/api/private")
    public String privateResource(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.getAuthorities());
        return "private-resource";
    }

}
