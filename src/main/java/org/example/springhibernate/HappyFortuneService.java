package org.example.springhibernate;

/**
 * @author 吴仙杰
 **/
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "今天是幸运的一天";
    }
}
