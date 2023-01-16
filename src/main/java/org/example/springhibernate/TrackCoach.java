package org.example.springhibernate;

/**
 * @author 吴仙杰
 **/
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "快跑 5 公里";
    }
}
