package org.SpringBoot_Learning.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${info.developer.name}")
    private String developerName;

    @Value("${info.developer.email}")
    private String developerEmail;

    @GetMapping("/")
    public String helloWorld() {
        return developerName + " - " + developerEmail;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Today I ran 5 kilometers!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }
}
