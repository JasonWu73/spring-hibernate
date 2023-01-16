package org.example.springhibernate;

/**
 * @author 吴仙杰
 **/
public class MyApp {

    public static void main(String[] args) {
        // 创建对象
        Coach theCoach = new TrackCoach();

        // 使用对象
        System.out.println(theCoach.getDailyWorkout());
    }
}
