package com.model;

import java.math.BigDecimal;
import java.util.Date;

public class Contrataciones {
    private int idContratacion;
    private Departamento departamento;
    private Empleados empleado; // Relación con Empleados
    private Cargos cargo; // Relación con Cargos
    private TipoContratacion tipoContratacion; // Relación con TipoContratacion
    private Date fechaContratacion;
    private BigDecimal salario;
    private boolean estado;

    // Constructor vacío
    public Contrataciones() {}

    // Constructor con parámetros
    public Contrataciones(int idContratacion, Departamento departamento, Empleados empleado, Cargos cargo, TipoContratacion tipoContratacion, Date fechaContratacion, BigDecimal salario, boolean estado) {
        this.idContratacion = idContratacion;
        this.departamento = departamento;
        this.empleado = empleado;
        this.cargo = cargo;
        this.tipoContratacion = tipoContratacion;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdContratacion() {
        return idContratacion;
    }

    public void setIdContratacion(int idContratacion) {
        this.idContratacion = idContratacion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public TipoContratacion getTipoContratacion() {
        return tipoContratacion;
    }

    public void setTipoContratacion(TipoContratacion tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
