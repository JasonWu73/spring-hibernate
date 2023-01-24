package org.example.springhibernate;

/**
 * @author 吴仙杰
 **/
public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "快跑 5 公里";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
