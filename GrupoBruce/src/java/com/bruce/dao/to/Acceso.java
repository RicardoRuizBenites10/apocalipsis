package com.bruce.dao.to;
// Generated 07/09/2018 11:57:55 AM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Acceso generated by hbm2java
 */
@Entity
@Table(name="ACCESO"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Acceso  implements java.io.Serializable {


     private AccesoId id;
     private String vistas;

    public Acceso() {
    }

	
    public Acceso(AccesoId id) {
        this.id = id;
    }
    public Acceso(AccesoId id, String vistas) {
       this.id = id;
       this.vistas = vistas;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idUsuario", column=@Column(name="ID_USUARIO", nullable=false, length=15) ), 
        @AttributeOverride(name="idMenu", column=@Column(name="ID_MENU", nullable=false) ) } )
    public AccesoId getId() {
        return this.id;
    }
    
    public void setId(AccesoId id) {
        this.id = id;
    }

    
    @Column(name="VISTAS", length=50)
    public String getVistas() {
        return this.vistas;
    }
    
    public void setVistas(String vistas) {
        this.vistas = vistas;
    }




}


