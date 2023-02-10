package org.example.springhibernate.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomService customService;

    /**
     * 获取客户列表。
     *
     * @param model View 层数据
     * @return 客户列表
     */
    @GetMapping
    public String getCustomers(Model model) {
        List<Customer> customers = customService.getCustomers();
        model.addAttribute("customers", customers);
        return "customer";
    }
}
