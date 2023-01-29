package org.example.springhibernate;

import org.springframework.stereotype.Component;

/**
 * 幸福财富.
 *
 * @author 吴仙杰
 **/
@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
}
