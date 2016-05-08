package com.tgzhao.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by tgzhao on 2016/5/8.
 */
public abstract class ConnectionFactory {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    static {
        try {
            url = "jdbc:mysql://127.0.0.1:3306/blog?useUnicode=true&characterEncoding=utf8";
            username = "root";
            password = "tgzhao";
            driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
