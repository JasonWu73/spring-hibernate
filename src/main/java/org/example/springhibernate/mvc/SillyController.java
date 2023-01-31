package org.example.springhibernate.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/silly")
public class SillyController {

    @GetMapping("/hello-world-form")
    public String showForm() {
        return "silly";
    }
}
