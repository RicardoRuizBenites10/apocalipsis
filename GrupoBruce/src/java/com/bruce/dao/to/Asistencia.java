package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Asistencia generated by hbm2java
 */
@Entity
@Table(name = "ASISTENCIA", schema = "dbo", catalog = "BDBRUCE")
@IdClass(value = AsistenciaId.class)
public class Asistencia implements java.io.Serializable {

    private String idTrabajador;
    private String idAsistencia;
    private Date fecha;
    private String hMarca;

    public Asistencia() {
    }

    public Asistencia(String idTrabajador, String idAsistencia, Date fecha, String hMarca) {
        this.idTrabajador = idTrabajador;
        this.idAsistencia = idAsistencia;
        this.fecha = fecha;
        this.hMarca = hMarca;
    }

    @Id
    @Column(name = "ID_TRABAJADOR", nullable = false, length = 15)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Id
    @Column(name = "ID_ASISTENCIA", nullable = false, length = 8)
    public String getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(String idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "HMARCA", nullable = false, length = 10)
    public String gethMarca() {
        return hMarca;
    }

    public void sethMarca(String hMarca) {
        this.hMarca = hMarca;
    }

}
