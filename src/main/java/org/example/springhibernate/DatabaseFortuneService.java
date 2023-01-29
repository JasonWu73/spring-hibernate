package org.example.springhibernate;

import org.springframework.stereotype.Component;

/**
 * 通过数据库获取财富.
 *
 * @author 吴仙杰
 **/
@Component
public class DatabaseFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "database fortune";
    }
}
