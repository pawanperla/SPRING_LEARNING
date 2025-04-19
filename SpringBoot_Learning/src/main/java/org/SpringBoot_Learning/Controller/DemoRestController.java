package org.SpringBoot_Learning.Controller;

import org.SpringBoot_Learning.Interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    // @Autowired
    // @Qualifier("hockeyCoach")
    private Coach coach;

    // Constructor-based dependency injection

    @Autowired
    public DemoRestController(@Qualifier("hockeyCoach") Coach coach) {
        System.out.println("Inside DemoRestController constructor");
        this.coach = coach;
    }

    // Setter-based dependency injection

    /*
     * @Autowired
     * public void setCoach(Coach coach) {
     * this.coach = coach;
     * }
     */

    // Method based dependency injection

    /*
     * @Autowired
     * public void doSomeStuff(Coach coach) {
     * this.coach = coach;
     * }
     */

    // Having multiple beans of the same type

    /*
     * @Autowired
     * public DemoRestController(@Qualifier("hockeyCoach") Coach coach) {
     * this.coach = coach;
     * }
     */

    // Setter-based dependency injection with @Qualifier

    /*
     * @Autowired
     * public void setCoach(@Qualifier("hockeyCoach") Coach coach) {
     * this.coach = coach;
     * }
     */

    // Primary bean with @Primary

    /*
     * @Autowired
     * public DemoRestController(Coach coach) {
     * this.coach = coach;
     * }
     */

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
