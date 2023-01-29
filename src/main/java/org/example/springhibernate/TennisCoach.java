package org.example.springhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 网球教练.
 *
 * @author 吴仙杰
 **/
@Component
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // define a setter method
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }
}
