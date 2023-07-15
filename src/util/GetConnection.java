package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class GetConnection {
    // Establish database connection
    private static Connection conn;

    public static Connection getConn() {
        return connection();
    }
    public static void closeConnection() throws SQLException {
        getConn().close();
    }

    GetConnection() {
        getConn();
    }

    private static Connection connection() {
        Properties mySql = new Properties();
        try (FileReader in = new FileReader("db.properties")) {
            mySql.load(in);
        } catch (IOException e) {
            System.out.println("Error loading db.properties from classpath." + e);
        }
        String username = mySql.getProperty("username");
        String password = mySql.getProperty("password");
        String url = mySql.getProperty("url");
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database." + e);
        }
        return conn;
    }
}