package com.labs.lucasian.main;


public class AdministradoraVO {
    private String codigoAdministradora;
    private String nombre;
    private String TipoIdentificacion;
    private String identificacion;
    private String naturaleza;
    private String multipleArp;
    private String fsp;
    private String fusionada;
    private String fechaFusion;

    public AdministradoraVO() {
    }

    public AdministradoraVO(String codigoAdministradora, String nombre, String identificacion, String naturaleza,
                            String multipleArp, String fsp, String fusionada, String fechaFusion) {
        this.codigoAdministradora = codigoAdministradora;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.naturaleza = naturaleza;
        this.multipleArp = multipleArp;
        this.fsp = fsp;
        this.fusionada = fusionada;
        this.fechaFusion = fechaFusion;
    }

    public String getTipoIdentificacion() {
        return TipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        TipoIdentificacion = tipoIdentificacion;
    }

    public String getCodigoAdministradora() {
        return codigoAdministradora;
    }

    public void setCodigoAdministradora(String codigoAdministradora) {
        this.codigoAdministradora = codigoAdministradora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getMultipleArp() {
        return multipleArp;
    }

    public void setMultipleArp(String multipleArp) {
        this.multipleArp = multipleArp;
    }

    public String getFsp() {
        return fsp;
    }

    public void setFsp(String fsp) {
        this.fsp = fsp;
    }

    public String getFusionada() {
        return fusionada;
    }

    public void setFusionada(String fusionada) {
        this.fusionada = fusionada;
    }

    public String getFechaFusion() {
        return fechaFusion;
    }

    public void setFechaFusion(String fechaFusion) {
        this.fechaFusion = fechaFusion;
    }
}
