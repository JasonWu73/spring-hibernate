package org.example.springhibernate.formtag;

import cn.hutool.core.lang.Console;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final PropertiesFactoryBean countryOptions;

    @GetMapping("/show-form")
    public String showForm(Model model) throws IOException {
        model.addAttribute("student", new Student());
        model.addAttribute("countryOptions", countryOptions.getObject());
        return "formtag/student-form";
    }

    @PostMapping("/process-form")
    public String processForm(@ModelAttribute Student student) {
        Console.log(student);
        return "formtag/student-confirmation";
    }
}
