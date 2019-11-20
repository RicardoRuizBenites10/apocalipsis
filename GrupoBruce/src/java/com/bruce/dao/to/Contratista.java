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
@Table(name = "CONTRATISTA", schema = "dbo", catalog = "BDBRUCE")
public class Contratista implements java.io.Serializable {

    private String idContratista;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private boolean situacion;

    public Contratista() {
    }

    @Id
    @Column(name = "ID_CONTRATISTA", nullable = false)
    public String getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(String idContratista) {
        this.idContratista = idContratista;
    }

    @Column(name = "NOMBRE", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "DIRECCION", nullable = false)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "TELEFONO", nullable = false)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name = "CORREO")
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
