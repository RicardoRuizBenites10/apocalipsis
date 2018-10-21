package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EstadoEstudio generated by hbm2java
 */
@Entity
@Table(name = "ESTADO_ESTUDIO",
         schema = "dbo",
         catalog = "BDBRUCE"
)
public class EstadoEstudio implements java.io.Serializable {

    private int idEestudio;
    private String descripcion;
    private boolean situacion;

    public EstadoEstudio() {
    }

    public EstadoEstudio(int idEestudio, String descripcion, boolean situacion) {
        this.idEestudio = idEestudio;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }

    @Id
    @Column(name = "ID_EESTUDIO", unique = true, nullable = false)
    public int getIdEestudio() {
        return this.idEestudio;
    }

    public void setIdEestudio(int idEestudio) {
        this.idEestudio = idEestudio;
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
