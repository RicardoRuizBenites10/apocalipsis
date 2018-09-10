package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TipoPermiso generated by hbm2java
 */
@Entity
@Table(name="TIPO_PERMISO"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class TipoPermiso  implements java.io.Serializable {


     private int idTpermiso;
     private String tipo;
     private boolean situacion;

    public TipoPermiso() {
    }

    public TipoPermiso(int idTpermiso, String tipo, boolean situacion) {
       this.idTpermiso = idTpermiso;
       this.tipo = tipo;
       this.situacion = situacion;
    }
   
     @Id 

    
    @Column(name="ID_TPERMISO", unique=true, nullable=false)
    public int getIdTpermiso() {
        return this.idTpermiso;
    }
    
    public void setIdTpermiso(int idTpermiso) {
        this.idTpermiso = idTpermiso;
    }

    
    @Column(name="TIPO", nullable=false, length=45)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }




}


