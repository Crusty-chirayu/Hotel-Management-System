package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class connection {

    Connection connection;
    Statement statement;

    public connection() {
        try {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/HotelMS", "chirayu", "chirayu"
                );
            } catch (Exception e1) {
                try {
                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/HotelMS", "prakash", "prakash"
                    );
                } catch (Exception e2) {
                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/HotelMS", "sagar", "sagar"
                    );
                }
            }
            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }
}
