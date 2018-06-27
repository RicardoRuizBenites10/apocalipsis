package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Genero generated by hbm2java
 */
@Entity
@Table(name="GENERO"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Genero  implements java.io.Serializable {


     private int idGenero;
     private String descripcion;
     private boolean situacion;
     private Set<Hijo> hijos = new HashSet<Hijo>(0);
     private Set<Persona> personas = new HashSet<Persona>(0);

    public Genero() {
    }

	
    public Genero(int idGenero, boolean situacion) {
        this.idGenero = idGenero;
        this.situacion = situacion;
    }
    public Genero(int idGenero, String descripcion, boolean situacion, Set<Hijo> hijos, Set<Persona> personas) {
       this.idGenero = idGenero;
       this.descripcion = descripcion;
       this.situacion = situacion;
       this.hijos = hijos;
       this.personas = personas;
    }
   
     @Id 

    
    @Column(name="ID_GENERO", unique=true, nullable=false)
    public int getIdGenero() {
        return this.idGenero;
    }
    
    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    
    @Column(name="DESCRIPCION", length=25)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="genero")
    public Set<Hijo> getHijos() {
        return this.hijos;
    }
    
    public void setHijos(Set<Hijo> hijos) {
        this.hijos = hijos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="genero")
    public Set<Persona> getPersonas() {
        return this.personas;
    }
    
    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }




}


