package org.example.springhibernate.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 配置 Spring Security。
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  /**
   * 添加测试用户。
   *
   * @return 用户数据
   */
  @Bean
  public UserDetailsService userDetailsService() {
    @SuppressWarnings("deprecation") final User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

    return new InMemoryUserDetailsManager(
      userBuilder.username("john").password("test123").roles("EMPLOYEE").build(),
      userBuilder.username("mary").password("test123").roles("MANAGER").build(),
      userBuilder.username("susan").password("test123").roles("ADMIN").build()
    );
  }
}
