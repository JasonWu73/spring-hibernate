package org.example.springhibernate;

/**
 * 悲伤的财富信息.
 *
 * @author 吴仙杰
 **/
public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is a sad day";
    }
}
