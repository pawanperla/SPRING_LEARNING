package org.SpringBoot_Learning.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
}
