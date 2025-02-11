package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/RecursosHumanos";
    private static final String USER = "root";
    private static final String PASSWORD = "tu_contraseña";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Empleados> getEmployees() throws SQLException {
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
                employees.add(employee);
            }
        }
        return employees;
    }
}