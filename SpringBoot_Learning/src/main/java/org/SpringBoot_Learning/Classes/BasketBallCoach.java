package org.SpringBoot_Learning.Classes;

import org.SpringBoot_Learning.Interfaces.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BasketBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on shooting practice.";
    }

}
