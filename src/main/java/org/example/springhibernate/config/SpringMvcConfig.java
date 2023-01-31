package org.example.springhibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.example.springhibernate")
public class SpringMvcConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        // JSP 位于 `src/main/webapp/WEB-INF/view` 下
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态资源配置, 位于 `src/main/webapp/asserts` 下
        // JSP 中使用为 `${pageContext.request.contextPath}/asserts/css/p.css`
        registry.addResourceHandler("/asserts/**").addResourceLocations("/asserts/");
    }
}
