package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ecivil generated by hbm2java
 */
@Entity
@Table(name = "ECIVIL",
         schema = "dbo",
         catalog = "BDBRUCE"
)
public class Ecivil implements java.io.Serializable {

    private int idEcivil;
    private String descripcion;
    private boolean situacion;

    public Ecivil() {
    }

    public Ecivil(int idEcivil, String descripcion, boolean situacion) {
        this.idEcivil = idEcivil;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_ECIVIL", unique = true, nullable = false)
    public int getIdEcivil() {
        return this.idEcivil;
    }

    public void setIdEcivil(int idEcivil) {
        this.idEcivil = idEcivil;
    }

    @Column(name = "DESCRIPCION", nullable = false, length = 25)
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
