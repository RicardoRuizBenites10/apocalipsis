package com.bruce.dao.to;
// Generated 06/09/2018 09:02:17 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sucursal generated by hbm2java
 */
@Entity
@Table(name="SUCURSAL"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Sucursal  implements java.io.Serializable {


     private String idSucursal;
     private String direccion;
     private boolean situacion;
     private String idEmpresa;

    public Sucursal() {
    }

    public Sucursal(String idSucursal, String direccion, boolean situacion, String idEmpresa) {
       this.idSucursal = idSucursal;
       this.direccion = direccion;
       this.situacion = situacion;
       this.idEmpresa = idEmpresa;
    }
   
     @Id 

    
    @Column(name="ID_SUCURSAL", unique=true, nullable=false, length=2)
    public String getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    
    @Column(name="DIRECCION", nullable=false, length=80)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    
    @Column(name="ID_EMPRESA", nullable=false, length=2)
    public String getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }




}


