<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Datos de la Empresa</title>
    ="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Lista de Empleados</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Usuario</th>
            <th>Teléfono</th>
            <th>Correo</th>
            <th>Fecha de Nacimiento</th>
            <th>DUI</th>
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
                <td>${employee.numeroDui}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>Cargos</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Cargo</th>
            <th>Descripción</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cargo" items="${cargos}">
            <tr>
                <td>${cargo.idCargo}</td>
                <td>${cargo.cargo}</td>
                <td>${cargo.descripcionCargo}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>Contrataciones</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Departamento</th>
            <th>Empleado</th>
            <th>Cargo</th>
            <th>Tipo de Contratación</th>
            <th>Fecha de Contratación</th>
            <th>Salario</th>
            <th>Estado</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contratacion" items="${contrataciones}">
            <tr>
                <td>${contratacion.idContratacion}</td>
                <td>${contratacion.departamento.nombreDepartamento}</td>
                <td>${contratacion.empleado.nombrePersona}</td>
                <td>${contratacion.cargo.cargo}</td>
                <td>${contratacion.tipoContratacion.tipoContratacion}</td>
                <td>${contratacion.fechaContratacion}</td>
                <td>${contratacion.salario}</td>
                <td>${contratacion.estado ? 'Activo' : 'Inactivo'}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="addEmployee.jsp" class="btn btn-primary">Agregar Nuevo Empleado</a>
</div>
</body>
</html>