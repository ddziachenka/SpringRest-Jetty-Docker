package com.epam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.99.100:3306/persons?serverTimezone=UTC&useSSL=false&useLegacyDatetimeCode=false";
    //private static final String URL = "jdbc:mysql://localhost:3306/persons?serverTimezone=UTC&useSSL=false&useLegacyDatetimeCode=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private DBManager() {
        throw new IllegalStateException("Utility class");
    }

    public static Connection getConnectionProvider() throws ClassNotFoundException, SQLException {
        Class.forName(CLASS_NAME);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
