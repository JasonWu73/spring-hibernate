package org.example.springhibernate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 配置 Spring Security。
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring()
      // Spring Security should completely ignore URLs starting with /resources/
      .requestMatchers("/assets/**");
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests()
      .anyRequest().authenticated()
      .and()
      .formLogin();

    return http.build();
  }

  /**
   * 添加测试用户。
   *
   * @return 用户数据
   */
  @Bean
  public UserDetailsService userDetailsService() {
    final UserDetails john = User.withUsername("john")
      .password(passwordEncoder().encode("test123"))
      .roles("EMPLOYEE")
      .build();
    final UserDetails mary = User.withUsername("mary")
      .password(passwordEncoder().encode("test123"))
      .roles("MANAGER")
      .build();
    final UserDetails susan = User.withUsername("susan")
      .password(passwordEncoder().encode("test123"))
      .roles("ADMIN")
      .build();

    return new InMemoryUserDetailsManager(john, mary, susan);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
