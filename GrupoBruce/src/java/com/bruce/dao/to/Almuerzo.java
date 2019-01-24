/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@IdClass(value = AlmuerzoId.class)
@Table(name = "ALMUERZO", schema = "dbo", catalog = "BDBRUCE")
public class Almuerzo implements java.io.Serializable {

    private String idTrabajador;
    private Date fecha;
    private boolean refrigerio;
    private boolean enComedor;
    private boolean procesado;
    
    private String trabajador;

    public Almuerzo() {
    }

    @Id
    @Column(name = "ID_TRABAJADOR", nullable = false)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Id
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "REFRIGERIO", nullable = false)
    public boolean isRefrigerio() {
        return refrigerio;
    }

    public void setRefrigerio(boolean refrigerio) {
        this.refrigerio = refrigerio;
    }

    @Column(name = "EN_COMEDOR", nullable = false)
    public boolean isEnComedor() {
        return enComedor;
    }

    public void setEnComedor(boolean enComedor) {
        this.enComedor = enComedor;
    }

    @Column(name = "PROCESADO", nullable = false)
    public boolean isProcesado() {
        return procesado;
    }

    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "TRABAJADOR", insertable = false, updatable = false)
    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public String toString() {
        return "Almuerzo{" + "idTrabajador=" + idTrabajador + ", fecha=" + fecha + ", refrigerio=" + refrigerio + ", enComedor=" + enComedor + ", procesado=" + procesado + ", trabajador=" + trabajador + '}';
    }
}
