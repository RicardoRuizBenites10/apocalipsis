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

/**
 *
 * @author SISTEMAS
 */
@Entity
@IdClass(value = MarcaId.class)
@Table(name = "MARCA", schema = "dbo", catalog = "BDBRUCE")
public class Marca implements java.io.Serializable {

    private String idTrabajador;
    private String idAsistencia;
    private String idMarca;
    private Date fecha;
    private String hmarca;
    private boolean situacion;

    public Marca() {
    }

    public Marca(String idTrabajador, String idAsistencia, String idMarca, Date fecha, String hmarca, boolean situacion) {
        this.idTrabajador = idTrabajador;
        this.idAsistencia = idAsistencia;
        this.idMarca = idMarca;
        this.fecha = fecha;
        this.hmarca = hmarca;
        this.situacion = situacion;
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
    @Column(name = "ID_ASISTENCIA", nullable = false)
    public String getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(String idAsistencia) {
        this.idAsistencia = idAsistencia;
    }
    
    @Id
    @Column(name = "ID_MARCA", nullable = false)
    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "HMARCA", nullable = false)
    public String getHmarca() {
        return hmarca;
    }

    public void setHmarca(String hmarca) {
        this.hmarca = hmarca;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

}
