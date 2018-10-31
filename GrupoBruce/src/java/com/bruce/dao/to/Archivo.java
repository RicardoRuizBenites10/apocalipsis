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
    private String extension;
    private int idDirectorio;
    private String nombre;
    
    private String fileB64;

    public Archivo() {
    }

    public Archivo(int idArchivo, String extension, int idDirectorio) {
        this.idArchivo = idArchivo;
        this.extension = extension;
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
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
    
    @Transient
    public String getFileB64() {
        return fileB64;
    }

    public void setFileB64(String fileB64) {
        this.fileB64 = fileB64;
    }

}
