package org.example.springhibernate.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomService customerService;

    /**
     * 客户列表页。
     *
     * @param model View 层数据
     * @return 客户列表页
     */
    @GetMapping
    public String getCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "customer";
    }

    /**
     * 新增客户页。
     *
     * @param model 用于绑定视图层数据
     * @return 新增客户页
     */
    @GetMapping("/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }

    /**
     * 保存客户。
     *
     * @return 保存成功则重定向至客户列表页
     */
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "add-customer";

        customerService.save(customer);
        return "redirect:/customer";
    }
}
