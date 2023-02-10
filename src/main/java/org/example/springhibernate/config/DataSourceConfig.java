package org.example.springhibernate.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement // 开启 Spring 事务管理
public class DataSourceConfig {

    /**
     * 装配 HikariCP 数据库连接池。
     *
     * @return HikariCP 数据库连接池
     */
    @Bean
    public DataSource dataSource() {
        // 设置 HikariCP 配置项
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/hibernate?useSSL=false&serverTimezone=Asia/Shanghai");
        config.setUsername("root");
        config.setPassword("qwe@123");

        // 使用配置项构建 HikariCP 数据库连接池
        return new HikariDataSource(config);
    }

    /**
     * 装配 Hibernate Session Factory。
     *
     * @return Hibernate Session Factory
     */
    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("org.example.springhibernate");

        Properties properties = new Properties();
        properties.put("hibernate.show_sql", true);
        sessionFactoryBean.setHibernateProperties(properties);

        // 初始化 Session Factory Bean，否则仅仅只是创建并不会初始化
        try {
            sessionFactoryBean.afterPropertiesSet();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sessionFactoryBean.getObject();
    }

    /**
     * 装配 Hibernate 事务管理器。
     *
     * @return Hibernate 事务管理器
     */
    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;
    }
}
