USE RecursosHumanos;
-- Crear la tabla Departamento
CREATE TABLE Departamento (
    idDepartamento INT AUTO_INCREMENT PRIMARY KEY,
    nombreDepartamento VARCHAR(59),
    descripcionDepartamento TEXT
);

-- Crear la tabla Cargos
CREATE TABLE Cargos (
    idCargo INT AUTO_INCREMENT PRIMARY KEY,
    cargo VARCHAR(50),
    descripcionCargo TEXT
);

-- Crear la tabla Empleados
CREATE TABLE Empleados (
    idEmpleado INT AUTO_INCREMENT PRIMARY KEY,
    nombrePersona VARCHAR(50),
    usuario VARCHAR(50),
    numeroTelefono VARCHAR(9),
    correoInstitucional VARCHAR(50),
    fechaNacimiento DATE
);

-- Crear la tabla TipoContratacion
CREATE TABLE TipoContratacion (
    idTipoContratacion INT AUTO_INCREMENT PRIMARY KEY,
    tipoContratacion VARCHAR(180),
    jefatura BOOLEAN
);

-- Crear la tabla Contrataciones
CREATE TABLE Contrataciones (
    idContratacion INT AUTO_INCREMENT PRIMARY KEY,
    idDepartamento INT,
    idEmpleado INT,
    idCargo INT,
    idTipoContratacion INT,
    fechaContratacion DATE,
    salario DECIMAL(18, 2),
    estado BOOLEAN,
    FOREIGN KEY (idDepartamento) REFERENCES Departamento(idDepartamento),
    FOREIGN KEY (idEmpleado) REFERENCES Empleados(idEmpleado),
    FOREIGN KEY (idCargo) REFERENCES Cargos(idCargo),
    FOREIGN KEY (idTipoContratacion) REFERENCES TipoContratacion(idTipoContratacion)
);
