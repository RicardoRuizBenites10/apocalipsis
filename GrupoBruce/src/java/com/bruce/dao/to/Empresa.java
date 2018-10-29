package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Empresa generated by hbm2java
 */
@Entity
@Table(name = "EMPRESA",
         schema = "dbo",
         catalog = "BDBRUCE"
)
public class Empresa implements java.io.Serializable {

    private String idEmpresa;
    private String descripcion;
    private boolean situacion;

    public Empresa() {
    }

    public Empresa(String idEmpresa, String descripcion, boolean situacion) {
        this.idEmpresa = idEmpresa;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_EMPRESA", unique = true, nullable = false, length = 2)
    public String getIdEmpresa() {
        return this.idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return this.situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

}
