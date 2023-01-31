package org.example.springhibernate.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/hello-world-form")
    public String showHelloWorldFormPage() {
        return "hello-world-form";
    }

    @PostMapping("process-form")
    public String confirmForm() {
        return "hello-world";
    }
}
