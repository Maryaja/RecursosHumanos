package model;

public class TipoContratacion {
    private int idTipoContratacion;
    private String tipoContratacion;
    private boolean jefatura;

    // Constructor vacío
    public TipoContratacion() {}

    // Constructor con parámetros
    public TipoContratacion(int idTipoContratacion, String tipoContratacion, boolean jefatura) {
        this.idTipoContratacion = idTipoContratacion;
        this.tipoContratacion = tipoContratacion;
        this.jefatura = jefatura;
    }

    // Getters y Setters
    public int getIdTipoContratacion() {
        return idTipoContratacion;
    }

    public void setIdTipoContratacion(int idTipoContratacion) {
        this.idTipoContratacion = idTipoContratacion;
    }

    public String getTipoContratacion() {
        return tipoContratacion;
    }

    public void setTipoContratacion(String tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

    public boolean isJefatura() {
        return jefatura;
    }

    public void setJefatura(boolean jefatura) {
        this.jefatura = jefatura;
    }
}