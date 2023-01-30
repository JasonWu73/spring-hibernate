package org.example.springhibernate;

/**
 * 足球教练.
 *
 * @author 吴仙杰
 **/
public class FootballCoach implements Coach {

    private FortuneService fortuneService;

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "绕操场跑10圈";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
