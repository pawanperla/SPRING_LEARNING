package org.SpringBoot_Learning.Classes;

import org.SpringBoot_Learning.Interfaces.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
// @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // Default scope
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // Prototype scope
// @Scope(WebApplicationContext.SCOPE_REQUEST) // Request scope
public class HockeyCoach implements Coach {

    public HockeyCoach() {
        System.out.println("Inside HockeyCoach constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your slap shot for 30 minutes.";
    }

}
