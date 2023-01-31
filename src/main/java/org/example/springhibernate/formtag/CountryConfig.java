package org.example.springhibernate.formtag;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class CountryConfig {

    @Bean
    public PropertiesFactoryBean countryOptions() {
        PropertiesFactoryBean countryOptions = new PropertiesFactoryBean();
        countryOptions.setLocation(new ClassPathResource("countries.properties"));
        return countryOptions;
    }
}
