package org.example.springhibernate;

/**
 * 教练类必须要实现的标准接口.
 *
 * @author 吴仙杰
 **/
public interface Coach {

    /**
     * 获取日常训练描述.
     *
     * @return 日常训练描述
     */
    String getDailyWorkout();

    /**
     * 获取每日财富.
     *
     * @return 每日财富信息
     */
    String getDailyFortune();
}
