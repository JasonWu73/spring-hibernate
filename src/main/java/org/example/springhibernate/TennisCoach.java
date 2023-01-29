package org.example.springhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 网球教练.
 *
 * @author 吴仙杰
 **/
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    @Autowired
    @Qualifier("RESTFortuneService")
    private FortuneService fortuneService;

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    // define my init method
    // code will execute after constructor and after injection of dependencies
    @PostConstruct
    public void init() {
        System.out.println(">> TennisCoach: inside of init() method");
    }

    // define my destroy method
    // code will execute before bean is destroyed
    @PreDestroy
    public void destroy() {
        System.out.println(">> TennisCoach: inside of destroy() method");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
