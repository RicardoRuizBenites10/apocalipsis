package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CargoContrato generated by hbm2java
 */
@Entity
@Table(name = "CARGO_CONTRATO",
         schema = "dbo",
         catalog = "BDBRUCE"
)
public class CargoContrato implements java.io.Serializable {

    private CargoContratoId id;
    private Cargo cargo;
    private ContratoTrabajador contratoTrabajador;
    private Date fecha;
    private String observacion;

    public CargoContrato() {
    }

    public CargoContrato(CargoContratoId id, Cargo cargo, ContratoTrabajador contratoTrabajador, Date fecha) {
        this.id = id;
        this.cargo = cargo;
        this.contratoTrabajador = contratoTrabajador;
        this.fecha = fecha;
    }

    public CargoContrato(CargoContratoId id, Cargo cargo, ContratoTrabajador contratoTrabajador, Date fecha, String observacion) {
        this.id = id;
        this.cargo = cargo;
        this.contratoTrabajador = contratoTrabajador;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "idTrabajador", column = @Column(name = "ID_TRABAJADOR", nullable = false, length = 15))
        , 
        @AttributeOverride(name = "idContrato", column = @Column(name = "ID_CONTRATO", nullable = false))
        , 
        @AttributeOverride(name = "idCcontrato", column = @Column(name = "ID_CCONTRATO", nullable = false))})
    public CargoContratoId getId() {
        return this.id;
    }

    public void setId(CargoContratoId id) {
        this.id = id;
    }

    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CARGO", nullable = false)
    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "ID_TRABAJADOR", referencedColumnName = "ID_TRABAJADOR", nullable = false, insertable = false, updatable = false)
        , 
        @JoinColumn(name = "ID_CONTRATO", referencedColumnName = "ID_CONTRATO", nullable = false, insertable = false, updatable = false)})
    public ContratoTrabajador getContratoTrabajador() {
        return this.contratoTrabajador;
    }

    public void setContratoTrabajador(ContratoTrabajador contratoTrabajador) {
        this.contratoTrabajador = contratoTrabajador;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false, length = 10)
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "OBSERVACION", length = 100)
    public String getObservacion() {
        return this.observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
