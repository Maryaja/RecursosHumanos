<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>AGREGAR EMPLEADO</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Agregar Nuevo Empleado</h1>
    <form action="AddEmployee" method="post">
        <div class="form-group">
            <label for="nombrePersona">Nombre:</label>
            <input type="text" class="form-control" id="nombrePersona" name="nombrePersona" required>
        </div>
        <div class="form-group">
            <label for="usuario">Usuario:</label>
            <input type="text" class="form-control" id="usuario" name="usuario" required>
        </div>
        <div class="form-group">
            <label for="numeroTelefono">Teléfono:</label>
            <input type="text" class="form-control" id="numeroTelefono" name="numeroTelefono" required>
        </div>
        <div class="form-group">
            <label for="correoInstitucional">Correo:</label>
            <input type="email" class="form-control" id="correoInstitucional" name="correoInstitucional" required>
        </div>
        <div class="form-group">
            <label for="fechaNacimiento">Fecha de Nacimiento:</label>
            <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" required>
        </div>
        <button type="submit" class="btn btn-primary">Agregar</button>
    </form>
</div>
</body>
</html>