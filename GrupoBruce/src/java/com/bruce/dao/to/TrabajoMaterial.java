/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "TRABAJO_MATERIAL", schema = "dbo", catalog = "BDBRUCE")
public class TrabajoMaterial implements java.io.Serializable{

    private int idTrabajador;
    private int idMaterial;
    private float cantidad;
    private int idUmedida;

    public TrabajoMaterial() {
    }

    @Id
    @Column(name = "ID_TRABAJADOR", nullable = false)
    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Id
    @Column(name = "ID_MATERIAL", nullable = false)
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Column(name = "CANTIDAD", nullable = false)
    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @Column(name = "ID_UMEDIDA", nullable = false)
    public int getIdUmedida() {
        return idUmedida;
    }

    public void setIdUmedida(int idUmedida) {
        this.idUmedida = idUmedida;
    }
}
