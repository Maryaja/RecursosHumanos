package com.model;

import com.recursoshumanos.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance().getConnection();
    }

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
            e.printStackTrace();
        }
        return employees;
    }

    public List<Cargos> getCargos() {
        List<Cargos> cargos = new ArrayList<>();
        String query = "SELECT * FROM Cargos";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cargos cargo = new Cargos();
                cargo.setIdCargo(rs.getInt("idCargo"));
                cargo.setCargo(rs.getString("cargo")); // Ajuste aquí
                cargo.setDescripcionCargo(rs.getString("descripcionCargo")); // Ajuste aquí
                cargos.add(cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargos;
    }

    public List<Contrataciones> getContrataciones() {
        List<Contrataciones> contrataciones = new ArrayList<>();
        String query = "SELECT * FROM Contrataciones";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Contrataciones contratacion = new Contrataciones();
                contratacion.setIdContratacion(rs.getInt("idContratacion"));
                // Ajusta los métodos según los campos de la clase Contrataciones
                contratacion.setFechaContratacion(rs.getDate("fechaContratacion"));
                contratacion.setSalario(rs.getBigDecimal("salario"));
                contratacion.setEstado(rs.getBoolean("estado"));
                // Aquí puedes agregar más campos según sea necesario
                contrataciones.add(contratacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contrataciones;
    }

    public void addEmployee(Empleados employee) {
        String query = "INSERT INTO Empleados (nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, employee.getNombrePersona());
            stmt.setString(2, employee.getUsuario());
            stmt.setString(3, employee.getNumeroTelefono());
            stmt.setString(4, employee.getCorreoInstitucional());
            stmt.setDate(5, new java.sql.Date(employee.getFechaNacimiento().getTime())); // Conversión correcta de fecha

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}