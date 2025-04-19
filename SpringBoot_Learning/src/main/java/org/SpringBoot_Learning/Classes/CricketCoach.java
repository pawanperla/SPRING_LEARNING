package org.SpringBoot_Learning.Classes;

import org.SpringBoot_Learning.Interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
