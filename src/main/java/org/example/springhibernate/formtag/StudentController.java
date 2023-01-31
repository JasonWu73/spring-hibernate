package org.example.springhibernate.formtag;

import cn.hutool.core.lang.Console;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/show-form")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "formtag/student-form";
    }

    @PostMapping("/process-form")
    public String processForm(@ModelAttribute Student student) {
        Console.log(student);
        return "formtag/student-confirmation";
    }
}
