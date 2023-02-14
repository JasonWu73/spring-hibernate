package org.example.springhibernate.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {

  @GetMapping("/")
  public String showIndexPage() {
    return "redirect:/admin";
  }
}
