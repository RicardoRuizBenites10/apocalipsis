/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "MANTENIMIENTO_DETALLE", schema = "dbo", catalog = "BDBRUCE")
@IdClass(value = MantenimientoDetalleId.class)
public class MantenimientoDetalle implements java.io.Serializable {

    private String idAequipo;
    private String idMantenimiento;
    private String idEinformatico;
    private boolean minterno;
    private String observacion;
    private float costo;

    public MantenimientoDetalle() {
    }

    public MantenimientoDetalle(String idAequipo, String idMantenimiento, String idEinformatico, boolean minterno, String observacion, float costo) {
        this.idAequipo = idAequipo;
        this.idMantenimiento = idMantenimiento;
        this.idEinformatico = idEinformatico;
        this.minterno = minterno;
        this.observacion = observacion;
        this.costo = costo;
    }

    @Id
    @Column(name = "ID_AEQUIPO", nullable = false)
    public String getIdAequipo() {
        return idAequipo;
    }

    public void setIdAequipo(String idAequipo) {
        this.idAequipo = idAequipo;
    }

    @Id
    @Column(name = "ID_MANTENIMIENTO", nullable = false)
    public String getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(String idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    @Id
    @Column(name = "ID_EINFORMATICO", nullable = false)
    public String getIdEinformatico() {
        return idEinformatico;
    }

    public void setIdEinformatico(String idEinformatico) {
        this.idEinformatico = idEinformatico;
    }

    @Column(name = "MINTERNO", nullable = false)
    public boolean isMinterno() {
        return minterno;
    }

    public void setMinterno(boolean minterno) {
        this.minterno = minterno;
    }

    @Column(name = "OBSERVACION")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    @Column(name="COSTO")
    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

}
