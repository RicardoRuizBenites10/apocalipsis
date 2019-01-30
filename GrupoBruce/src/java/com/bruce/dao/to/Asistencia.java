package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

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
    private String marca1;
    private String marca2;
    private String marca3;
    private String marca4;
    private String marca5;
    private String marca6;
    private String marca7;
    private int anio;
    private int mes;
    private int dia;
    private int ausencia;
    private boolean procesado;

    private String fechaTemp;
    private String trabajador;

    public Asistencia() {
    }

    public Asistencia(String idTrabajador, Date fecha, String marca1, String marca7, int anio, int mes, int dia, int ausencia) {
        this.idTrabajador = idTrabajador;
        this.fecha = fecha;
        this.marca1 = marca1;
        this.marca7 = marca7;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.ausencia = ausencia;
    }

    public Asistencia(String idTrabajador, String idAsistencia, Date fecha, String marca1, int anio, int mes, int dia, int ausencia) {
        this.idTrabajador = idTrabajador;
        this.idAsistencia = idAsistencia;
        this.fecha = fecha;
        this.marca1 = marca1;
        this.marca7 = marca1;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.ausencia = ausencia;
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
    @Column(name = "FECHA", nullable = false, length = 10)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Transient
    public String getFechaTemp() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(this.fecha);
    }

    public void setFechaTemp(String fechaTemp) {
        this.fechaTemp = fechaTemp;
    }

    @Column(name = "MARCA1", nullable = false)
    public String getMarca1() {
        return marca1;
    }

    public void setMarca1(String marca1) {
        this.marca1 = marca1;
    }

    @Column(name = "MARCA2")
    public String getMarca2() {
        return marca2;
    }

    public void setMarca2(String marca2) {
        this.marca2 = marca2;
    }

    @Column(name = "MARCA3")
    public String getMarca3() {
        return marca3;
    }

    public void setMarca3(String marca3) {
        this.marca3 = marca3;
    }

    @Column(name = "MARCA4")
    public String getMarca4() {
        return marca4;
    }

    public void setMarca4(String marca4) {
        this.marca4 = marca4;
    }

    @Column(name = "MARCA5")
    public String getMarca5() {
        return marca5;
    }

    public void setMarca5(String marca5) {
        this.marca5 = marca5;
    }

    @Column(name = "MARCA6")
    public String getMarca6() {
        return marca6;
    }

    public void setMarca6(String marca6) {
        this.marca6 = marca6;
    }

    @Column(name = "MARCA7", nullable = false)
    public String getMarca7() {
        return marca7;
    }

    public void setMarca7(String marca7) {
        this.marca7 = marca7;
    }

    @Column(name = "ANIO", nullable = false)
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Column(name = "MES", nullable = false)
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Column(name = "DIA", nullable = false)
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Column(name = "AUSENCIA", nullable = false)
    public int getAusencia() {
        return ausencia;
    }

    public void setAusencia(int ausencia) {
        this.ausencia = ausencia;
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

}
