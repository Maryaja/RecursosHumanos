package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddEmployeeController", urlPatterns = {"/AddEmployee"})
public class AddEmployeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nombrePersona = request.getParameter("nombrePersona");
            String usuario = request.getParameter("usuario");
            String numeroTelefono = request.getParameter("numeroTelefono");
            String correoInstitucional = request.getParameter("correoInstitucional");
            String fechaNacimiento = request.getParameter("fechaNacimiento");

            String url = "jdbc:mysql://localhost:3306/recursoshumanos";
            String user = "root";
            String password = "$Admin1992";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement()) {
                String query = "INSERT INTO empleados (nombrePersona, usuario, numeroTelefono, correoInstitucional, fechaNacimiento) VALUES ('"
                        + nombrePersona + "', '" + usuario + "', '" + numeroTelefono + "', '" + correoInstitucional + "', '" + fechaNacimiento + "')";
                stmt.executeUpdate(query);
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