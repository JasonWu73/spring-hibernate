package org.example.springhibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @SuppressWarnings("deprecation")
  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user = User.withDefaultPasswordEncoder()
      .username("user")
      .password("test123")
      .roles("USER")
      .build();

    UserDetails admin = User.withDefaultPasswordEncoder()
      .username("admin")
      .password("test1293")
      .roles("ADMIN", "USER")
      .build();

    return new InMemoryUserDetailsManager(user, admin);
  }
}
