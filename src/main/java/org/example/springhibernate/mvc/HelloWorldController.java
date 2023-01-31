package org.example.springhibernate.mvc;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;
import java.util.Optional;

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

    /**
     * 将姓名转为大写形式，并增加 message 字段值.
     */
    @PostMapping("process-form-shout")
    public String shoutForm(HttpServletRequest request, Model model) {
        // read the request parameter from the HTML form
        String studentName = Optional.ofNullable(request.getParameter("studentName")).orElse("");

        // convert the data to all caps
        studentName = studentName.toUpperCase(Locale.ROOT);

        // create the message
        String resultMessage = "Yo! " + (studentName.isEmpty() ? "Anonymous" : studentName);

        // add message to the model
        model.addAttribute("message", resultMessage);

        return "hello-world";
    }
}
