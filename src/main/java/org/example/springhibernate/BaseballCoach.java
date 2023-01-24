package org.example.springhibernate;

/**
 * @author 吴仙杰
 **/
public class BaseballCoach implements Coach {

    private final FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "30 分钟击球练习";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
