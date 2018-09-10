package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comisionrp generated by hbm2java
 */
@Entity
@Table(name = "COMISIONRP",
         schema = "dbo",
         catalog = "BDBRUCE"
)
public class Comisionrp implements java.io.Serializable {

    private int idComisionrp;
    private String descripcion;
    private BigDecimal fondo;
    private BigDecimal seguro;
    private BigDecimal comision;
    private String idRpensionario;

    public Comisionrp() {
    }

    public Comisionrp(int idComisionrp, String descripcion, BigDecimal fondo, BigDecimal seguro, BigDecimal comision, String idRpensionario) {
        this.idComisionrp = idComisionrp;
        this.descripcion = descripcion;
        this.fondo = fondo;
        this.seguro = seguro;
        this.comision = comision;
        this.idRpensionario = idRpensionario;
    }

    @Id

    @Column(name = "ID_COMISIONRP", unique = true, nullable = false)
    public int getIdComisionrp() {
        return this.idComisionrp;
    }

    public void setIdComisionrp(int idComisionrp) {
        this.idComisionrp = idComisionrp;
    }

    @Column(name = "DESCRIPCION", nullable = false, length = 25)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "FONDO", nullable = false, scale = 4)
    public BigDecimal getFondo() {
        return this.fondo;
    }

    public void setFondo(BigDecimal fondo) {
        this.fondo = fondo;
    }

    @Column(name = "SEGURO", nullable = false, scale = 4)
    public BigDecimal getSeguro() {
        return this.seguro;
    }

    public void setSeguro(BigDecimal seguro) {
        this.seguro = seguro;
    }

    @Column(name = "COMISION", nullable = false, scale = 4)
    public BigDecimal getComision() {
        return this.comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    @Column(name = "ID_RPENSIONARIO", nullable = false, length = 2)
    public String getIdRpensionario() {
        return this.idRpensionario;
    }

    public void setIdRpensionario(String idRpensionario) {
        this.idRpensionario = idRpensionario;
    }

}
