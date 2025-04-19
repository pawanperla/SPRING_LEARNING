package org.SpringBoot_Learning.Classes;

import org.SpringBoot_Learning.Interfaces.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // Default scope
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Prototype scope
// @Scope(WebApplicationContext.SCOPE_REQUEST) // Request scope
public class HockeyCoach implements Coach {

    public HockeyCoach() {
        System.out.println("Inside HockeyCoach constructor");
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("HockeyCoach: Inside doMyStartupStuff");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("HockeyCoach: Inside doMyCleanupStuff");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your slap shot for 30 minutes.";
    }

}
