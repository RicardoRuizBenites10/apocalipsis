package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Permiso generated by hbm2java
 */
@Entity
@Table(name="PERMISO"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Permiso  implements java.io.Serializable {


     private PermisoId id;
     private Date fechaRetorno;
     private int idTpermiso;

    public Permiso() {
    }

    public Permiso(PermisoId id, Date fechaRetorno, int idTpermiso) {
       this.id = id;
       this.fechaRetorno = fechaRetorno;
       this.idTpermiso = idTpermiso;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idTrabajador", column=@Column(name="ID_TRABAJADOR", nullable=false, length=15) ), 
        @AttributeOverride(name="fechaSalida", column=@Column(name="FECHA_SALIDA", nullable=false, length=10) ) } )
    public PermisoId getId() {
        return this.id;
    }
    
    public void setId(PermisoId id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_RETORNO", nullable=false, length=10)
    public Date getFechaRetorno() {
        return this.fechaRetorno;
    }
    
    public void setFechaRetorno(Date fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    
    @Column(name="ID_TPERMISO", nullable=false)
    public int getIdTpermiso() {
        return this.idTpermiso;
    }
    
    public void setIdTpermiso(int idTpermiso) {
        this.idTpermiso = idTpermiso;
    }




}


