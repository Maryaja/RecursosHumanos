package com.recursoshumanos;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();
            if (conn != null) {
                System.out.println("Conexión establecida correctamente.");
            } else {
                System.out.println("Error en la conexión.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
