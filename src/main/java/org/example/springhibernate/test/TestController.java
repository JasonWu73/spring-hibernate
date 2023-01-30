package org.example.springhibernate.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试 Controller.
 *
 * @author 吴仙杰
 **/
@Controller
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
