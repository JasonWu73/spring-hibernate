package org.example.springhibernate.validator;

import cn.hutool.core.lang.Console;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    /**
     * 自动处理表单参数: 去除 String 参数的前后空格, 且当仅包含空白字符时, 设置为 null.
     */
    @InitBinder
    public void setStringTrimmer(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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
        // for debugging
        Console.log("Last Name: |{}|", customer.getLastName());

        if (bindingResult.hasErrors()) {
            return "validator/customer-form";
        }
        return "validator/customer-confirmation";
    }
}
