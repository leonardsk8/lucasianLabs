package com.labs.lucasian.main;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "ADMINISTRADORA", schema = "ADMIN")
public class AdministradoraEntity {
    private Long id;
    private String codigo;
    private String nombre;
    private String codTpId;
    private String nroId;
    private String naturaleza;
    private Boolean multipleArp;
    private Boolean fps;
    private Boolean fusionada;
    private Time fechaFusion;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @SequenceGenerator(name="MY_SEQ_ID_ADMINISTRADORA",allocationSize = 1,sequenceName = "SEQ_ID_ADMINISTRADORA")
    @GeneratedValue(generator = "MY_SEQ_ID_ADMINISTRADORA")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CODIGO", nullable = true, length = 20)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 200)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "COD_TP_ID", nullable = true, length = 2)
    public String getCodTpId() {
        return codTpId;
    }

    public void setCodTpId(String codTpId) {
        this.codTpId = codTpId;
    }

    @Basic
    @Column(name = "NRO_ID", nullable = true, length = 50)
    public String getNroId() {
        return nroId;
    }

    public void setNroId(String nroId) {
        this.nroId = nroId;
    }

    @Basic
    @Column(name = "NATURALEZA", nullable = true, length = 50)
    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    @Basic
    @Column(name = "MULTIPLE_ARP", nullable = true, precision = 0)
    public Boolean getMultipleArp() {
        return multipleArp;
    }

    public void setMultipleArp(Boolean multipleArp) {
        this.multipleArp = multipleArp;
    }

    @Basic
    @Column(name = "FPS", nullable = true, precision = 0)
    public Boolean getFps() {
        return fps;
    }

    public void setFps(Boolean fps) {
        this.fps = fps;
    }

    @Basic
    @Column(name = "FUSIONADA", nullable = true, precision = 0)
    public Boolean getFusionada() {
        return fusionada;
    }

    public void setFusionada(Boolean fusionada) {
        this.fusionada = fusionada;
    }

    @Basic
    @Column(name = "FECHA_FUSION", nullable = true)
    public Time getFechaFusion() {
        return fechaFusion;
    }

    public void setFechaFusion(Time fechaFusion) {
        this.fechaFusion = fechaFusion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdministradoraEntity that = (AdministradoraEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (codTpId != null ? !codTpId.equals(that.codTpId) : that.codTpId != null) return false;
        if (nroId != null ? !nroId.equals(that.nroId) : that.nroId != null) return false;
        if (naturaleza != null ? !naturaleza.equals(that.naturaleza) : that.naturaleza != null) return false;
        if (multipleArp != null ? !multipleArp.equals(that.multipleArp) : that.multipleArp != null) return false;
        if (fps != null ? !fps.equals(that.fps) : that.fps != null) return false;
        if (fusionada != null ? !fusionada.equals(that.fusionada) : that.fusionada != null) return false;
        if (fechaFusion != null ? !fechaFusion.equals(that.fechaFusion) : that.fechaFusion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (codTpId != null ? codTpId.hashCode() : 0);
        result = 31 * result + (nroId != null ? nroId.hashCode() : 0);
        result = 31 * result + (naturaleza != null ? naturaleza.hashCode() : 0);
        result = 31 * result + (multipleArp != null ? multipleArp.hashCode() : 0);
        result = 31 * result + (fps != null ? fps.hashCode() : 0);
        result = 31 * result + (fusionada != null ? fusionada.hashCode() : 0);
        result = 31 * result + (fechaFusion != null ? fechaFusion.hashCode() : 0);
        return result;
    }
}
