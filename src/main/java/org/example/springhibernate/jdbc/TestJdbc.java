package org.example.springhibernate.jdbc;

import cn.hutool.core.lang.Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate?useSSL=false&serverTimezone=Asia/Shanghai&";
        String userName = "root";
        String password = "qwe@123";

        Console.log("连接 MySQL 服务: {}", jdbcUrl);
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Console.log("连接成功!!!");
    }
}
