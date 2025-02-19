package com.controller;

import com.model.DatabaseManager;
import com.model.Empleados;
import com.model.Cargos;
import com.model.Contrataciones;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseManager dbManager = new DatabaseManager();
        List<Empleados> employees = dbManager.getEmployees();
        List<Cargos> cargos = dbManager.getCargos();
        List<Contrataciones> contrataciones = dbManager.getContrataciones();

        request.setAttribute("employees", employees);
        request.setAttribute("cargos", cargos);
        request.setAttribute("contrataciones", contrataciones);
        request.getRequestDispatcher("/showData.jsp").forward(request, response);
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