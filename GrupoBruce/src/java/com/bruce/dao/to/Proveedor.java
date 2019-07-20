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
@Table(name = "PROVEEDOR", schema = "dbo", catalog = "BDBRUCE")
public class Proveedor implements java.io.Serializable {

    private String idProveedor;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String ccorriente1;
    private String ccorriente2;
    private boolean situacion;

    public Proveedor() {
    }

    public Proveedor(String idProveedor, String nombre, boolean situacion) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_PROVEEDOR", nullable = false)
    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Column(name = "NOMBRE", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "DIRECCION")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "TELEFONO")
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

    @Column(name = "CCORRIENTE1")
    public String getCcorriente1() {
        return ccorriente1;
    }

    public void setCcorriente1(String ccorriente1) {
        this.ccorriente1 = ccorriente1;
    }

    @Column(name = "CCORRIENTE2")
    public String getCcorriente2() {
        return ccorriente2;
    }

    public void setCcorriente2(String ccorriente2) {
        this.ccorriente2 = ccorriente2;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
