package com.recursoshumanos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/RecursosHumanos";
    private static final String USER = "root";
    private static final String PASSWORD = "$Admin1992";

    // Instancia única (Singleton)
    private static DatabaseConnection instance;
    private final Connection connection;

    // Constructor privado para evitar instanciación externa
    private DatabaseConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            throw new SQLException("Error al conectar con la base de datos", e);
        }
    }

    // Método estático para obtener la instancia única
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.connection.isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }
}
