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
import javax.persistence.Transient;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "ARCHIVO", schema = "dbo", catalog = "BDBRUCE")
public class Archivo implements java.io.Serializable {

    private int idArchivo;
    private String extencion;
    private int idDirectorio;
    
    private String fileB64;

    public Archivo() {
    }

    public Archivo(int idArchivo, String extencion, int idDirectorio) {
        this.idArchivo = idArchivo;
        this.extencion = extencion;
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

    @Column(name = "EXTENCION", nullable = false)
    public String getExtencion() {
        return extencion;
    }

    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }

    @Column(name = "ID_DIRECTORIO", nullable = false)
    public int getIdDirectorio() {
        return idDirectorio;
    }

    public void setIdDirectorio(int idDirectorio) {
        this.idDirectorio = idDirectorio;
    }
    
    @Transient
    public String getFileB64() {
        return fileB64;
    }

    public void setFileB64(String fileB64) {
        this.fileB64 = fileB64;
    }

}
