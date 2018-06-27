package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ContratoTrabajador generated by hbm2java
 */
@Entity
@Table(name="CONTRATO_TRABAJADOR"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class ContratoTrabajador  implements java.io.Serializable {


     private ContratoTrabajadorId id;
     private EstadoContrato estadoContrato;
     private TiempoContrato tiempoContrato;
     private TipoContrato tipoContrato;
     private Trabajador trabajador;
     private Date fechaInicio;
     private Date fechaFin;
     private Date fechaCese;
     private Set<Remuneracion> remuneracions = new HashSet<Remuneracion>(0);
     private Set<CargoContrato> cargoContratos = new HashSet<CargoContrato>(0);

    public ContratoTrabajador() {
    }

	
    public ContratoTrabajador(ContratoTrabajadorId id, EstadoContrato estadoContrato, TiempoContrato tiempoContrato, TipoContrato tipoContrato, Trabajador trabajador, Date fechaInicio) {
        this.id = id;
        this.estadoContrato = estadoContrato;
        this.tiempoContrato = tiempoContrato;
        this.tipoContrato = tipoContrato;
        this.trabajador = trabajador;
        this.fechaInicio = fechaInicio;
    }
    public ContratoTrabajador(ContratoTrabajadorId id, EstadoContrato estadoContrato, TiempoContrato tiempoContrato, TipoContrato tipoContrato, Trabajador trabajador, Date fechaInicio, Date fechaFin, Date fechaCese, Set<Remuneracion> remuneracions, Set<CargoContrato> cargoContratos) {
       this.id = id;
       this.estadoContrato = estadoContrato;
       this.tiempoContrato = tiempoContrato;
       this.tipoContrato = tipoContrato;
       this.trabajador = trabajador;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.fechaCese = fechaCese;
       this.remuneracions = remuneracions;
       this.cargoContratos = cargoContratos;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idTrabajador", column=@Column(name="ID_TRABAJADOR", nullable=false, length=15) ), 
        @AttributeOverride(name="idContrato", column=@Column(name="ID_CONTRATO", nullable=false) ) } )
    public ContratoTrabajadorId getId() {
        return this.id;
    }
    
    public void setId(ContratoTrabajadorId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_ECONTRATO", nullable=false)
    public EstadoContrato getEstadoContrato() {
        return this.estadoContrato;
    }
    
    public void setEstadoContrato(EstadoContrato estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TIEMPO", nullable=false)
    public TiempoContrato getTiempoContrato() {
        return this.tiempoContrato;
    }
    
    public void setTiempoContrato(TiempoContrato tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TCONTRATO", nullable=false)
    public TipoContrato getTipoContrato() {
        return this.tipoContrato;
    }
    
    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TRABAJADOR", nullable=false, insertable=false, updatable=false)
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_INICIO", nullable=false, length=10)
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_FIN", length=10)
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_CESE", length=10)
    public Date getFechaCese() {
        return this.fechaCese;
    }
    
    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="contratoTrabajador")
    public Set<Remuneracion> getRemuneracions() {
        return this.remuneracions;
    }
    
    public void setRemuneracions(Set<Remuneracion> remuneracions) {
        this.remuneracions = remuneracions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="contratoTrabajador")
    public Set<CargoContrato> getCargoContratos() {
        return this.cargoContratos;
    }
    
    public void setCargoContratos(Set<CargoContrato> cargoContratos) {
        this.cargoContratos = cargoContratos;
    }




}


