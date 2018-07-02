/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import com.bruce.util.Metodo;

/**
 *
 * @author SISTEMAS
 */
public class TrabajadorDTO {

    private String codigo;
    private String nombres;
    private String telefono;
    private String direccion;
    private String tipoTrabajador;
    private String estadoTrabajador;

    public TrabajadorDTO() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoTrabajador() {
        return tipoTrabajador;
    }

    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    public String getEstadoTrabajador() {
        return estadoTrabajador;
    }

    public void setEstadoTrabajador(String estadoTrabajador) {
        this.estadoTrabajador = estadoTrabajador;
    }
}
