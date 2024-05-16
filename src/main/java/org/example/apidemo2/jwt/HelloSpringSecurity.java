package org.example.apidemo2.jwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringSecurity {

    @GetMapping("/hellospringsecurity")
    public String hellospringsecurity() {
        return "hellospringsecurity";
    }
}