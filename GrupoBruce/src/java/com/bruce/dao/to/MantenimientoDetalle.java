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

    private int idAequipo;
    private String idMantenimiento;
    private int idEinformatico;
    private boolean minterno;
    private String observacion;

    public MantenimientoDetalle() {
    }

    public MantenimientoDetalle(int idAequipo, String idMantenimiento, int idEinformatico, boolean minterno, String observacion) {
        this.idAequipo = idAequipo;
        this.idMantenimiento = idMantenimiento;
        this.idEinformatico = idEinformatico;
        this.minterno = minterno;
        this.observacion = observacion;
    }

    @Id
    @Column(name = "ID_AEQUIPO", nullable = false)
    public int getIdAequipo() {
        return idAequipo;
    }

    public void setIdAequipo(int idAequipo) {
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
    public int getIdEinformatico() {
        return idEinformatico;
    }

    public void setIdEinformatico(int idEinformatico) {
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

}
