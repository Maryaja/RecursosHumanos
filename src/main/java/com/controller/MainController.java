package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LISTA DE EMPLEADOS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>LISTA DE EMPLEADOS</h1>");
            out.println("<a href='addEmployee.jsp'>Add New Employee</a><br><br>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Username</th><th>Phone Number</th><th>Email</th><th>Date of Birth</th></tr>");

            // Conexión a la base de datos
            String url = "jdbc:mysql://localhost:3306/recursoshumanos";
            String user = "root";
            String password = "$Admin1992";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM Empleados")) {

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("idEmpleado") + "</td>");
                    out.println("<td>" + rs.getString("nombrePersona") + "</td>");
                    out.println("<td>" + rs.getString("usuario") + "</td>");
                    out.println("<td>" + rs.getString("numeroTelefono") + "</td>");
                    out.println("<td>" + rs.getString("correoInstitucional") + "</td>");
                    out.println("<td>" + rs.getDate("fechaNacimiento") + "</td>");
                    out.println("</tr>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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