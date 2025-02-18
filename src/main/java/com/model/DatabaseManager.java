package com.model;

import com.recursoshumanos.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    // Obtener conexión desde Singleton
    private static Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance().getConnection();
    }

    // Método para obtener empleados
    public List<Empleados> getEmployees() {
        List<Empleados> employees = new ArrayList<>();
        String query = "SELECT * FROM Empleados";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Empleados employee = new Empleados();
                employee.setIdEmpleado(rs.getInt("idEmpleado"));
                employee.setNombrePersona(rs.getString("nombrePersona"));
                employee.setUsuario(rs.getString("usuario"));
                employee.setNumeroTelefono(rs.getString("numeroTelefono"));
                employee.setCorreoInstitucional(rs.getString("correoInstitucional"));
                employee.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                employee.setNumeroDui(rs.getString("numeroDui"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Puedes cambiarlo por un log en un archivo
        }
        return employees;
    }
}
