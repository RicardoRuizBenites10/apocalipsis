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
@Table(name = "ARCHIVO", schema = "dbo", catalog = "BDBRUCE")
public class Archivo implements java.io.Serializable {

    private int idArchivo;
    private String nombre;
    private String afterB64;
    private String beforeB64;
    private int idDirectorio;

    public Archivo() {
    }

    public Archivo(int idArchivo, String nombre, String afterB64, String beforeB64, int idDirectorio) {
        this.idArchivo = idArchivo;
        this.nombre = nombre;
        this.afterB64 = afterB64;
        this.beforeB64 = beforeB64;
        this.idDirectorio = idDirectorio;
    }
    
    @Id
    @Column(name = "ID_ARCHIVO", nullable = false)
    public int getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    @Column(name = "ID_DIRECTORIO", nullable = false)
    public int getIdDirectorio() {
        return idDirectorio;
    }

    public void setIdDirectorio(int idDirectorio) {
        this.idDirectorio = idDirectorio;
    }
    
    @Column(name="NOMBRE", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Column(name="AFTERB64")
    public String getAfterB64() {
        return afterB64;
    }

    public void setAfterB64(String afterB64) {
        this.afterB64 = afterB64;
    }
    
    @Column(name="BEFOREB64", nullable = false)
    public String getBeforeB64() {
        return beforeB64;
    }

    public void setBeforeB64(String beforeB64) {
        this.beforeB64 = beforeB64;
    }

}
