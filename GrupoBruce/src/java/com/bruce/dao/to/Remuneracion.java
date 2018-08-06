package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.math.BigDecimal;
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
 * Remuneracion generated by hbm2java
 */
@Entity
@Table(name = "REMUNERACION",
        schema = "dbo",
        catalog = "BDBRUCE"
)
public class Remuneracion implements java.io.Serializable {

    private RemuneracionId id;
    private ContratoTrabajador contratoTrabajador;
    private Date fecha;
    private BigDecimal monto;

    public Remuneracion() {
    }

    public Remuneracion(RemuneracionId id, ContratoTrabajador contratoTrabajador, Date fecha, BigDecimal monto) {
        this.id = id;
        this.contratoTrabajador = contratoTrabajador;
        this.fecha = fecha;
        this.monto = monto;
    }

    @EmbeddedId

    @AttributeOverrides({
        @AttributeOverride(name = "idTrabajador", column = @Column(name = "ID_TRABAJADOR", nullable = false, length = 15))
        , 
        @AttributeOverride(name = "idContrato", column = @Column(name = "ID_CONTRATO", nullable = false))
        , 
        @AttributeOverride(name = "idRemuneracion", column = @Column(name = "ID_REMUNERACION", nullable = false))})
    public RemuneracionId getId() {
        return this.id;
    }

    public void setId(RemuneracionId id) {
        this.id = id;
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

    @Column(name = "MONTO", nullable = false, precision = 13, scale = 4)
    public BigDecimal getMonto() {
        return this.monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

}
