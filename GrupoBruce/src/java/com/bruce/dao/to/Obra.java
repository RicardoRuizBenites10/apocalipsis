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
@Table(name = "OBRA", schema = "dbo", catalog = "BDBRUCE")
public class Obra implements java.io.Serializable {

    private int idObra;
    private Date fecha;
    private int numero;
    private int anio;
    private String nombre;
    private String nroChasis;
    private Date fechaIngreso;
    private Date fechaSalida;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean hascontratista;
    private boolean gopintura;
    private Date gopinturafecha;
    private int asientoNroorden;
    private Date asientoRecepcion;
    private Date ejecucion;
    private Date detenido;
    private Date terminado;
    private Date entregadosto;
    private Date entregadocli;
    private String idObrtip;
    private String idProforma;
    private String idUsuario;
    private String idEobra;

    private String tipo;
    private String cliente;

    public Obra() {
    }

    @Id
    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Column(name = "NOMBRE", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "NUMERO", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name = "ANIO", nullable = false)
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INICIO")
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_FIN")
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Column(name = "NRO_CHASIS")
    public String getNroChasis() {
        return nroChasis;
    }

    public void setNroChasis(String nroChasis) {
        this.nroChasis = nroChasis;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INGRESO", nullable = false)
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_SALIDA", nullable = false)
    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Column(name = "HASCONTRATISTA", nullable = false)
    public boolean isHascontratista() {
        return hascontratista;
    }

    public void setHascontratista(boolean hascontratista) {
        this.hascontratista = hascontratista;
    }

    @Column(name = "GOPINTURA", nullable = false)
    public boolean isGopintura() {
        return gopintura;
    }

    public void setGopintura(boolean gopintura) {
        this.gopintura = gopintura;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "GOPINTURAFECHA", nullable = false)
    public Date getGopinturafecha() {
        return gopinturafecha;
    }

    public void setGopinturafecha(Date gopinturafecha) {
        this.gopinturafecha = gopinturafecha;
    }

    @Column(name = "ASIENTO_NROORDEN", nullable = true)
    public int getAsientoNroorden() {
        return asientoNroorden;
    }

    public void setAsientoNroorden(int asientoNroorden) {
        this.asientoNroorden = asientoNroorden;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ASIENTO_RECEPCION", nullable = false)
    public Date getAsientoRecepcion() {
        return asientoRecepcion;
    }

    public void setAsientoRecepcion(Date asientoRecepcion) {
        this.asientoRecepcion = asientoRecepcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "EJECUCION", nullable = true)
    public Date getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(Date ejecucion) {
        this.ejecucion = ejecucion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DETENIDO", nullable = true)
    public Date getDetenido() {
        return detenido;
    }

    public void setDetenido(Date detenido) {
        this.detenido = detenido;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "TERMINADO", nullable = true)
    public Date getTerminado() {
        return terminado;
    }

    public void setTerminado(Date terminado) {
        this.terminado = terminado;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ENTREGADOSTO", nullable = true)
    public Date getEntregadosto() {
        return entregadosto;
    }

    public void setEntregadosto(Date entregadosto) {
        this.entregadosto = entregadosto;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ENTREGADOCLI", nullable = true)
    public Date getEntregadocli() {
        return entregadocli;
    }

    public void setEntregadocli(Date entregadocli) {
        this.entregadocli = entregadocli;
    }

    @Column(name = "ID_USUARIO", nullable = false)
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name = "ID_EOBRA", nullable = false)
    public String getIdEobra() {
        return idEobra;
    }

    public void setIdEobra(String idEobra) {
        this.idEobra = idEobra;
    }

    @Column(name = "ID_OBRTIP", nullable = false)
    public String getIdObrtip() {
        return idObrtip;
    }

    public void setIdObrtip(String idObrtip) {
        this.idObrtip = idObrtip;
    }

    @Column(name = "ID_PROFORMA", nullable = false)
    public String getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(String idProforma) {
        this.idProforma = idProforma;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "TIPO", insertable = false, updatable = false)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "CLIENTE", insertable = false, updatable = false)
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
