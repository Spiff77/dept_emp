package com.mycompany.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagement {

    Connection connection = null;

    private static ConnectionManagement INSTANCE;

    private ConnectionManagement(){
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             this.connection = DriverManager.getConnection("jdbc:mysql://localhost:9999/scott?user=root");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ConnectionManagement getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ConnectionManagement();
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection(){
        try {
            if(connection != null && !connection.isClosed())
                this.connection.close();
        } catch (SQLException e) {
            System.out.println("ERREUR SYSTEM");
        }finally {
            connection = null;
            INSTANCE = null;
        }
    }
}
