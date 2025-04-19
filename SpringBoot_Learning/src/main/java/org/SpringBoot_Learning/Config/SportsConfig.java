package org.SpringBoot_Learning.Config;

import org.SpringBoot_Learning.Classes.SwimCoach;
import org.SpringBoot_Learning.Interfaces.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean("acquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
