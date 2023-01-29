package org.example.springhibernate;

import org.springframework.stereotype.Component;

/**
 * 返回 REST 标准的财富.
 *
 * @author 吴仙杰
 **/
@Component
public class RESTFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "REST Fortune";
    }
}
