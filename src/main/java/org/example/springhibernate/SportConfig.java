package org.example.springhibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 项目配置.
 *
 * @author 吴仙杰
 **/
@Configuration
//@ComponentScan("org.example.springhibernate")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    // define bean for our sad fortune service
    @Bean
    public FortuneService sadFortuneService() {
        System.out.println("SportConfig: inside sadFortuneService() method");
        return new SadFortuneService();
    }

    // define bean for our swim coach and inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }

    @Bean
    public Coach footballCoach() {
        return new FootballCoach(sadFortuneService());

    }
}
