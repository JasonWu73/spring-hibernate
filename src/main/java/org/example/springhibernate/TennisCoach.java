package org.example.springhibernate;

import org.springframework.stereotype.Component;

/**
 * 网球教练.
 *
 * @author 吴仙杰
 **/
@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
