package org.example.springhibernate.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
     * 新增客户的表单页。
     *
     * @param model 用于绑定视图层数据
     * @return 客户表单页
     */
    @GetMapping("/form-add")
    public String formForAdd(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    /**
     * 修改客户的表单页。
     *
     * @param model 用于绑定视图层数据
     * @return 客户表单页
     */
    @GetMapping("/form-update")
    public String formForUpdate(@RequestParam long customerId,
                                Model model) {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    /**
     * 保存客户（新增或修改）。
     *
     * @return 保存成功则重定向至客户列表页
     */
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute @Valid Customer customer,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "customer-form";

        if (customer.getId() == null) {
            customerService.save(customer);
        } else {
            customerService.update(customer);
        }
        return "redirect:/customer";
    }

    /**
     * 删除客户。
     *
     * @param customerId 需要删除的客户 id
     * @return 删除成功则重定向至客户列表页
     */
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam long customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customer";
    }
}
