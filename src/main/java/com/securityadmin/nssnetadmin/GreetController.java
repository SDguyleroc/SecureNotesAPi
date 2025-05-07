package com.securityadmin.nssnetadmin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/hello")
    public String greet(){
        return "hello";
    }


    @GetMapping("/public/contact")
    public String contact()
    {
        return "contact";
        }
}
