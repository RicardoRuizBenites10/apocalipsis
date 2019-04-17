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
@IdClass(value = RequerimientoDetalleId.class)
@Table(name = "REQUERIMIENTO_DETALLE", schema = "dbo", catalog = "BDBRUCE")
public class RequerimientoDetalle implements java.io.Serializable {

    private int idRequerimiento;
    private int idMaterial;
    private float requerido;
    private float despachado;
    private boolean pendiente;
    private int idUmedida;

    public RequerimientoDetalle() {
    }

    @Id
    @Column(name = "ID_REQUERIMIENTO", nullable = false)
    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    @Id
    @Column(name = "ID_MATERIAL", nullable = false)
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Column(name = "REQUERIDO", nullable = false)
    public float getRequerido() {
        return requerido;
    }

    public void setRequerido(float requerido) {
        this.requerido = requerido;
    }

    @Column(name = "DESPACHADO", nullable = false)
    public float getDespachado() {
        return despachado;
    }

    public void setDespachado(float despachado) {
        this.despachado = despachado;
    }

    @Column(name = "PENDIENTE", nullable = false)
    public boolean isPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }

    @Column(name = "ID_UMEDIDA", nullable = false)
    public int getIdUmedida() {
        return idUmedida;
    }

    public void setIdUmedida(int idUmedida) {
        this.idUmedida = idUmedida;
    }
}
