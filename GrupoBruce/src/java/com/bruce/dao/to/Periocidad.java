package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Periocidad generated by hbm2java
 */
@Entity
@Table(name = "PERIOCIDAD",
        schema = "dbo",
        catalog = "BDBRUCE"
)
public class Periocidad implements java.io.Serializable {

    private int idPeriocidad;
    private String descripcion;
    private boolean situacion;
    private Set<Trabajador> trabajadors = new HashSet<Trabajador>(0);

    public Periocidad() {
    }

    public Periocidad(int idPeriocidad, String descripcion, boolean situacion) {
        this.idPeriocidad = idPeriocidad;
        this.descripcion = descripcion;
        this.situacion = situacion;
    }

    public Periocidad(int idPeriocidad, String descripcion, boolean situacion, Set<Trabajador> trabajadors) {
        this.idPeriocidad = idPeriocidad;
        this.descripcion = descripcion;
        this.situacion = situacion;
        this.trabajadors = trabajadors;
    }

    @Id

    @Column(name = "ID_PERIOCIDAD", unique = true, nullable = false)
    public int getIdPeriocidad() {
        return this.idPeriocidad;
    }

    public void setIdPeriocidad(int idPeriocidad) {
        this.idPeriocidad = idPeriocidad;
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

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "periocidad")
    public Set<Trabajador> getTrabajadors() {
        return this.trabajadors;
    }

    public void setTrabajadors(Set<Trabajador> trabajadors) {
        this.trabajadors = trabajadors;
    }

}
