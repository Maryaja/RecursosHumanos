package com.controller;

import com.model.DatabaseManager;
import com.model.Empleados;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddEmployeeController", urlPatterns = {"/AddEmployee"})
public class AddEmployeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombrePersona = request.getParameter("nombrePersona");
        String usuario = request.getParameter("usuario");
        String numeroTelefono = request.getParameter("numeroTelefono");
        String correoInstitucional = request.getParameter("correoInstitucional");
        String fechaNacimiento = request.getParameter("fechaNacimiento");

        Empleados employee = new Empleados();
        employee.setNombrePersona(nombrePersona);
        employee.setUsuario(usuario);
        employee.setNumeroTelefono(numeroTelefono);
        employee.setCorreoInstitucional(correoInstitucional);
        employee.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento));

        DatabaseManager dbManager = new DatabaseManager();
        dbManager.addEmployee(employee);

        response.sendRedirect("MainController");
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