package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Asistencia generated by hbm2java
 */
@Entity
@Table(name="ASISTENCIA"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Asistencia  implements java.io.Serializable {


     private AsistenciaId id;
     private Trabajador trabajador;
     private String asistencia;
     private Date hingreso;
     private Date hsalida;

    public Asistencia() {
    }

	
    public Asistencia(AsistenciaId id, Trabajador trabajador, String asistencia) {
        this.id = id;
        this.trabajador = trabajador;
        this.asistencia = asistencia;
    }
    public Asistencia(AsistenciaId id, Trabajador trabajador, String asistencia, Date hingreso, Date hsalida) {
       this.id = id;
       this.trabajador = trabajador;
       this.asistencia = asistencia;
       this.hingreso = hingreso;
       this.hsalida = hsalida;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idTrabajador", column=@Column(name="ID_TRABAJADOR", nullable=false, length=15) ), 
        @AttributeOverride(name="fecha", column=@Column(name="FECHA", nullable=false, length=10) ) } )
    public AsistenciaId getId() {
        return this.id;
    }
    
    public void setId(AsistenciaId id) {
        this.id = id;
    }
    
    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TRABAJADOR", nullable=false, insertable=false, updatable=false)
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    
    @Column(name="ASISTENCIA", nullable=false, length=10)
    public String getAsistencia() {
        return this.asistencia;
    }
    
    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="HINGRESO", length=16)
    public Date getHingreso() {
        return this.hingreso;
    }
    
    public void setHingreso(Date hingreso) {
        this.hingreso = hingreso;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="HSALIDA", length=16)
    public Date getHsalida() {
        return this.hsalida;
    }
    
    public void setHsalida(Date hsalida) {
        this.hsalida = hsalida;
    }




}


