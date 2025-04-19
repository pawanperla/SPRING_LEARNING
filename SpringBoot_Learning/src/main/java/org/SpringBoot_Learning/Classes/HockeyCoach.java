package org.SpringBoot_Learning.Classes;

import org.SpringBoot_Learning.Interfaces.Coach;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your slap shot for 30 minutes.";
    }

}
