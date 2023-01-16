package org.example.springhibernate;

/**
 * @author 吴仙杰
 **/
public class BaseballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "30 分钟击球练习";
    }
}
