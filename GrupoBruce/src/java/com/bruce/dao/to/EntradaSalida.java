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
 * EntradaSalida generated by hbm2java
 */
@Entity
@Table(name="ENTRADA_SALIDA"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class EntradaSalida  implements java.io.Serializable {


     private EntradaSalidaId id;
     private TipoEs tipoEs;
     private Trabajador trabajador;
     private Date fecha;
     private Date hentrada;

    public EntradaSalida() {
    }

	
    public EntradaSalida(EntradaSalidaId id, TipoEs tipoEs, Trabajador trabajador, Date fecha) {
        this.id = id;
        this.tipoEs = tipoEs;
        this.trabajador = trabajador;
        this.fecha = fecha;
    }
    public EntradaSalida(EntradaSalidaId id, TipoEs tipoEs, Trabajador trabajador, Date fecha, Date hentrada) {
       this.id = id;
       this.tipoEs = tipoEs;
       this.trabajador = trabajador;
       this.fecha = fecha;
       this.hentrada = hentrada;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idTrabajador", column=@Column(name="ID_TRABAJADOR", nullable=false, length=15) ), 
        @AttributeOverride(name="hsalida", column=@Column(name="HSALIDA", nullable=false, length=16) ) } )
    public EntradaSalidaId getId() {
        return this.id;
    }
    
    public void setId(EntradaSalidaId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TES", nullable=false)
    public TipoEs getTipoEs() {
        return this.tipoEs;
    }
    
    public void setTipoEs(TipoEs tipoEs) {
        this.tipoEs = tipoEs;
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

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="HENTRADA", length=16)
    public Date getHentrada() {
        return this.hentrada;
    }
    
    public void setHentrada(Date hentrada) {
        this.hentrada = hentrada;
    }




}


