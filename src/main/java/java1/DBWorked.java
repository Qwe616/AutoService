package java1;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.*;

public class DBWorked {
    private Connection connection;
    public static String url = "";
    public DBWorked() {
        try {
            Driver driver = new SQLServerDriver();
            DriverManager.registerDriver(driver);
            String URL = url;
            String USERNAME = "admin";
            String PASSWORD = "1234";
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }
}
