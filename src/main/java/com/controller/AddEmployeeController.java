package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.recursoshumanos.DatabaseConnection;

@WebServlet(name = "AddEmployeeController", urlPatterns = {"/AddEmployee"})
public class AddEmployeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private DatabaseConnection databaseConnection;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nombrePersona = request.getParameter("nombrePersona");
            String usuario = request.getParameter("usuario");
            String numeroTelefono = request.getParameter("numeroTelefono");
            String correoInstitucional = request.getParameter("correoInstitucional");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String numeroDui = request.getParameter("numeroDui");

            String query = "INSERT INTO empleados (nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento, numeroDui) VALUES (?, ?, ?, ?, ?, ?)";

            try (Connection conn = databaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, nombrePersona);
                pstmt.setString(2, usuario);
                pstmt.setString(3, numeroTelefono);
                pstmt.setString(4, correoInstitucional);
                pstmt.setString(5, fechaNacimiento);
                pstmt.setString(6, numeroDui);
                pstmt.executeUpdate();
                out.println("Empleado agregado exitosamente!");
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("Error al agregar el empleado.");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}