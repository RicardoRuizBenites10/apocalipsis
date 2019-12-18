/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author SISTEMAS
 */
@Entity
@Table(name = "ESTADO_OBRA", catalog = "BDBRUCE", schema = "dbo")
public class EstadoObra implements java.io.Serializable {

    private String idEobra;
    private String nombre;
    private boolean xllegar;
    private boolean ejecucion;
    private boolean detenido;
    private boolean terminado;
    private boolean entregadosto;
    private boolean entregadocli;
    private boolean situacion;

    public EstadoObra() {
    }

    @Id
    @Column(name = "ID_EOBRA", nullable = false)
    public String getIdEobra() {
        return idEobra;
    }

    public void setIdEobra(String idEobra) {
        this.idEobra = idEobra;
    }

    @Column(name = "NOMBRE", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "XLLEGAR", nullable = false)
    public boolean isXllegar() {
        return xllegar;
    }

    public void setXllegar(boolean xllegar) {
        this.xllegar = xllegar;
    }

    @Column(name = "EJECUCION", nullable = false)
    public boolean isEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(boolean ejecucion) {
        this.ejecucion = ejecucion;
    }

    @Column(name = "DETENIDO", nullable = false)
    public boolean isDetenido() {
        return detenido;
    }

    public void setDetenido(boolean detenido) {
        this.detenido = detenido;
    }

    @Column(name = "TERMINADO", nullable = false)
    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    @Column(name = "ENTREGADOSTO", nullable = false)
    public boolean isEntregadosto() {
        return entregadosto;
    }

    public void setEntregadosto(boolean entregadosto) {
        this.entregadosto = entregadosto;
    }

    @Column(name = "ENTREGADOCLI", nullable = false)
    public boolean isEntregadocli() {
        return entregadocli;
    }

    public void setEntregadocli(boolean entregadocli) {
        this.entregadocli = entregadocli;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }
}
