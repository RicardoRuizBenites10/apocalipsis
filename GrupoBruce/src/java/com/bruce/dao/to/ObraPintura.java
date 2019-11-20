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
@IdClass(value = ObraPinturaId.class)
@Table(name = "OBRA_PINTURA", schema = "dbo", catalog = "BDBRUCE")
public class ObraPintura implements java.io.Serializable {

    private int idObra;
    private String idCdiseno;
    private Date fecha;

    private String colordiseno;

    public ObraPintura() {
    }

    @Id
    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Id
    @Column(name = "ID_CDISENO", nullable = false)
    public String getIdCdiseno() {
        return idCdiseno;
    }

    public void setIdCdiseno(String idCdiseno) {
        this.idCdiseno = idCdiseno;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "COLORDISENO", insertable = false, updatable = false)
    public String getColordiseno() {
        return colordiseno;
    }

    public void setColordiseno(String colordiseno) {
        this.colordiseno = colordiseno;
    }
}
