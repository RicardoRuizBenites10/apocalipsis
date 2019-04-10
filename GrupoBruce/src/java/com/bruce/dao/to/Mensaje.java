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

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "MENSAJE", schema = "dbo", catalog = "BDBRUCE")
public class Mensaje implements java.io.Serializable {

    private long idMensaje;
    private String contenido;
    private String nomArchivo;
    private String urlArchivo;
    private Date fecha;
    private String hora;
    private String idSender;
    private String idReceiver;

    public Mensaje() {
    }

    public Mensaje(long idMensaje, String contenido, String nomArchivo, String urlArchivo, Date fecha, String hora, String idSender, String idReceiver) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.nomArchivo = nomArchivo;
        this.urlArchivo = urlArchivo;
        this.fecha = fecha;
        this.hora = hora;
        this.idSender = idSender;
        this.idReceiver = idReceiver;
    }

    @Id
    @Column(name = "ID_MENSAJE", nullable = false)
    public long getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(long idMensaje) {
        this.idMensaje = idMensaje;
    }

    @Column(name = "CONTENIDO", nullable = false)
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Column(name = "NOM_ARCHIVO")
    public String getNomArchivo() {
        return nomArchivo;
    }

    public void setNomArchivo(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }

    @Column(name = "URL_ARCHIVO")
    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA", nullable = false)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "HORA", nullable = false)
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Column(name = "ID_SENDER", nullable = false)
    public String getIdSender() {
        return idSender;
    }

    public void setIdSender(String idSender) {
        this.idSender = idSender;
    }

    @Column(name = "ID_RECEIVER", nullable = false)
    public String getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(String idReceiver) {
        this.idReceiver = idReceiver;
    }
}
