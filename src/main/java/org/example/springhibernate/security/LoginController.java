package org.example.springhibernate.security;

import cn.hutool.core.lang.Console;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  @GetMapping("/show-login-page")
  public String showLoginPage() {
    Console.log("show login page....");
    return "login";
  }
}
