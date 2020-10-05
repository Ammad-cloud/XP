package com.example.xpprojectgroupone.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

    static String URL;
    static String USER;
    static String PASSWORD;


    public static Connection getDBConnection() {

        /*
        Connect to config.properties
         */
        Properties prop = new Properties();
        try {
            FileInputStream propertyFile = new FileInputStream("src/main/resources/application.properties");
            prop.load(propertyFile);
            USER = prop.getProperty("username");
            PASSWORD = prop.getProperty("password");
            URL = prop.getProperty("url");
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException throwables) {
            System.out.println(URL + USER + PASSWORD);
        }
    /*
        Connection Manager
         */

        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
