package com.model;

public class Cargos {
    private int idCargo;
    private String cargo;
    private String descripcionCargo;

    // Constructor vacío
    public Cargos() {}

    // Constructor con parámetros
    public Cargos(int idCargo, String cargo, String descripcionCargo) {
        this.idCargo = idCargo;
        this.cargo = cargo;
        this.descripcionCargo = descripcionCargo;
    }

    // Getters y Setters
    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }
}