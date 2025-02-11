<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Employee List</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Username</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Date of Birth</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.idEmpleado}</td>
                <td>${employee.nombrePersona}</td>
                <td>${employee.usuario}</td>
                <td>${employee.numeroTelefono}</td>
                <td>${employee.correoInstitucional}</td>
                <td>${employee.fechaNacimiento}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>