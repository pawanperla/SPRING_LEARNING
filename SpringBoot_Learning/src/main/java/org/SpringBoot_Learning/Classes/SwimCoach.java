package org.SpringBoot_Learning.Classes;

import org.SpringBoot_Learning.Interfaces.Coach;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("Inside SwimCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm-up.";
    }
}
