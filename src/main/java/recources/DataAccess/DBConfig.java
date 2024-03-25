/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recources.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author induwara
 */
public class DBConfig {
    private static DBConfig instance;
    private Connection connection;
    
    private static final String URL = "jdbc:mysql://localhost:3306/abc_lab";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private DBConfig() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DBConfig getConn() {
        instance = null;
        if (instance == null) {
            synchronized (DBConfig.class) {
                if (instance == null) {
                    instance = new DBConfig();
                }
            }
        }
        return instance;
    }

    // Get connection
    public Connection getConnection() {
        return connection;
    }
}
