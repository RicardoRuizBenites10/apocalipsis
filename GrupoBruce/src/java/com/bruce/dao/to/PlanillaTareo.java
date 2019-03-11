/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@IdClass(value = PlanillaTareoId.class)
@Table(name = "PLANILLA_TAREO", schema = "dbo", catalog = "BDBRUCE")
public class PlanillaTareo implements java.io.Serializable {

    private int idPplanilla;
    private String idTrabajador;
    private float haberBasico;
    private int diasPeriodo;
    private int diasTrabajado;
    private float horasDesct;
    private float hextra25;
    private float hextra35;
    private float adelanto;
    private float prestamo;
    private float movilidad;
    private float reintegro;
    private float devolucion;
    private float flagAsig;
    private float flagAfp;
    private float otrosDesct;
    private int diasPlame;
    private float empRmv;
    private boolean aprobado;
    private boolean procesado;

    private String trabajador;

    public PlanillaTareo() {
    }

    public PlanillaTareo(int idPplanilla, String idTrabajador, float haberBasico, int diasPeriodo, int diasTrabajado, float horasDesct, float hextra25, float hextra35, float adelanto, float prestamo, float movilidad, float reintegro, float devolucion, float flagAsig, float flagAfp) {
        this.idPplanilla = idPplanilla;
        this.idTrabajador = idTrabajador;
        this.haberBasico = haberBasico;
        this.diasPeriodo = diasPeriodo;
        this.diasTrabajado = diasTrabajado;
        this.horasDesct = horasDesct;
        this.hextra25 = hextra25;
        this.hextra35 = hextra35;
        this.adelanto = adelanto;
        this.prestamo = prestamo;
        this.movilidad = movilidad;
        this.reintegro = reintegro;
        this.devolucion = devolucion;
        this.flagAsig = flagAsig;
        this.flagAfp = flagAfp;
    }

    @Id
    @Column(name = "ID_PPLANILLA", nullable = false)
    public int getIdPplanilla() {
        return idPplanilla;
    }

    public void setIdPplanilla(int idPplanilla) {
        this.idPplanilla = idPplanilla;
    }

    @Id
    @Column(name = "ID_TRABAJADOR", nullable = false)
    public String getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Column(name = "HABER_BASICO", nullable = false)
    public float getHaberBasico() {
        return haberBasico;
    }

    public void setHaberBasico(float haberBasico) {
        this.haberBasico = haberBasico;
    }

    @Column(name = "PRP_DIAS_PER", nullable = false)
    public int getDiasPeriodo() {
        return diasPeriodo;
    }

    public void setDiasPeriodo(int diasPeriodo) {
        this.diasPeriodo = diasPeriodo;
    }

    @Column(name = "PRP_DIAS_TRAB", nullable = false)
    public int getDiasTrabajado() {
        return diasTrabajado;
    }

    public void setDiasTrabajado(int diasTrabajado) {
        this.diasTrabajado = diasTrabajado;
    }

    @Column(name = "NUM_H_DESCT", nullable = false)
    public float getHorasDesct() {
        return horasDesct;
    }

    public void setHorasDesct(float horasDesct) {
        this.horasDesct = horasDesct;
    }

    @Column(name = "NUM_H_EXT25", nullable = false)
    public float getHextra25() {
        return hextra25;
    }

    public void setHextra25(float hextra25) {
        this.hextra25 = hextra25;
    }

    @Column(name = "NUM_H_EXT35", nullable = false)
    public float getHextra35() {
        return hextra35;
    }

    public void setHextra35(float hextra35) {
        this.hextra35 = hextra35;
    }

    @Column(name = "ADELANTO", nullable = false)
    public float getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(float adelanto) {
        this.adelanto = adelanto;
    }

    @Column(name = "PRESTAMO", nullable = false)
    public float getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(float prestamo) {
        this.prestamo = prestamo;
    }

    @Column(name = "MOVILIDAD", nullable = false)
    public float getMovilidad() {
        return movilidad;
    }

    public void setMovilidad(float movilidad) {
        this.movilidad = movilidad;
    }

    @Column(name = "REINTEGRO", nullable = false)
    public float getReintegro() {
        return reintegro;
    }

    public void setReintegro(float reintegro) {
        this.reintegro = reintegro;
    }

    @Column(name = "DEVOLUCION", nullable = false)
    public float getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(float devolucion) {
        this.devolucion = devolucion;
    }

    @Column(name = "FLAG_ASIG", nullable = false)
    public float getFlagAsig() {
        return flagAsig;
    }

    public void setFlagAsig(float flagAsig) {
        this.flagAsig = flagAsig;
    }

    @Column(name = "FLAG_AFP", nullable = false)
    public float getFlagAfp() {
        return flagAfp;
    }

    public void setFlagAfp(float flagAfp) {
        this.flagAfp = flagAfp;
    }

    @Column(name = "OTROS_DESCT", nullable = false)
    public float getOtrosDesct() {
        return otrosDesct;
    }

    public void setOtrosDesct(float otrosDesct) {
        this.otrosDesct = otrosDesct;
    }
    
    @Column(name="DIAS_PLAME", nullable = false)
    public int getDiasPlame() {
        return diasPlame;
    }

    public void setDiasPlame(int diasPlame) {
        this.diasPlame = diasPlame;
    }

    @Column(name="EMP_RMV", nullable = false)
    public float getEmpRmv() {
        return empRmv;
    }

    public void setEmpRmv(float empRmv) {
        this.empRmv = empRmv;
    }
    
    @Column(name="APROBADO", nullable = false)
    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    @Column(name="PROCESADO", nullable = false)
    public boolean isProcesado() {
        return procesado;
    }

    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "TRABAJADOR", nullable = false)
    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }
}
