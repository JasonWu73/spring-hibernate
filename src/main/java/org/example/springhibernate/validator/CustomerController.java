package org.example.springhibernate.validator;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/show-form")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "validator/customer-form";
    }

    @PostMapping("/process-form")
    public String processForm(
        @Valid
        @ModelAttribute("customer")
        Customer customer,
        BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "validator/customer-form";
        }
        return "validator/customer-confirmation";
    }
}
