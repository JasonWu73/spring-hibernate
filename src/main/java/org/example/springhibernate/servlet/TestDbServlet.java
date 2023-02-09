package org.example.springhibernate.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 测试 JDBC 可用性。
 */
@WebServlet("/test-db-servlet")
public class TestDbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        // 数据库连接属性
        String userName = "root";
        String password = "qwe@123";
        String jdbcUrl = "jdbc:mysql://localhost:3306/hibernate?useSSL=false&serverTimezone=Asia/Shanghai";

        // 连接数据库
        PrintWriter writer = response.getWriter();
        response.setHeader("Content-Type", "text/plain;charset=utf8");
        writer.println("连接数据库：" + jdbcUrl);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
            writer.println("连接成功");
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
