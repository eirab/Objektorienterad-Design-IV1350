package integration;

import java.sql.*;
import java.util.Properties;

public class DBHandler {

        private Properties properties;
        private final String url = "jdbc:postgresql://localhost:5432/POS";


    public DBHandler(){
        this.properties = new Properties();
        this.properties.setProperty("user","postgres");
        this.properties.setProperty("password","menneedLONK!");
        this.properties.setProperty("ssl","false");
    }


    public void connect() {
        try {
            DriverManager.getConnection(url, properties);
            System.out.println("Connected to database");


        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}


