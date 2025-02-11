<%--
  Created by IntelliJ IDEA.
  User: RIVAS
  Date: 09/02/2025
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h1>Add New Employee</h1>
<form action="AddEmployee" method="post">
    <label for="nombrePersona">Name:</label>
    <input type="text" id="nombrePersona" name="nombrePersona" required><br>
    <label for="usuario">Username:</label>
    <input type="text" id="usuario" name="usuario" required><br>
    <label for="numeroTelefono">Phone Number:</label>
    <input type="text" id="numeroTelefono" name="numeroTelefono" required><br>
    <label for="correoInstitucional">Email:</label>
    <input type="email" id="correoInstitucional" name="correoInstitucional" required><br>
    <label for="fechaNacimiento">Date of Birth:</label>
    <input type="date" id="fechaNacimiento" name="fechaNacimiento" required><br>
    <input type="submit" value="Add Employee">
</form>
</body>
</html>