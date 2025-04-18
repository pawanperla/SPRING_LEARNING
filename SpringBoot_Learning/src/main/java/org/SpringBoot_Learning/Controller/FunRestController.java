package org.SpringBoot_Learning.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${developer.name}")
    private String developerName;

    @Value("${developer.email}")
    private String developerEmail;

    @GetMapping("/")
    public String helloWorld() {
        return developerName + " - " + developerEmail;
    }
}
