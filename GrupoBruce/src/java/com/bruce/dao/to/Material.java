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

/**
 *
 * @author SISTEMAS
 */
@Entity
@IdClass(value = MaterialId.class)
@Table(name = "MATERIAL", schema = "dbo", catalog = "BDBRUCE")
public class Material implements java.io.Serializable {

    private String idEmpresa;
    private String idSucursal;
    private int idMaterial;
    private String nombre;
    private float precio;
    private float stock;
    private float stockMinimo;
    private float stockMaximo;
    private float cantIngreso;
    private float cantSalida;
    private boolean autoparte;
    private boolean segCalidad;
    private int idFamilia;
    private int idSubfamilia;
    private String idUsuario;

    public Material() {
    }

    @Id
    @Column(name = "ID_EMPRESA", nullable = false)
    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Id
    @Column(name = "ID_SUCURSAL", nullable = false)
    public String getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Id
    @Column(name = "ID_MATERIAL", nullable = false)
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Column(name = "NOMBRE", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "PRECIO", nullable = false)
    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Column(name = "STOCK", nullable = false)
    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    @Column(name = "STOCK_MINIMO", nullable = false)
    public float getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(float stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    @Column(name = "STOCK_MAXIMO", nullable = false)
    public float getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(float stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    @Column(name = "CANT_INGRESO", nullable = false)
    public float getCantIngreso() {
        return cantIngreso;
    }

    public void setCantIngreso(float cantIngreso) {
        this.cantIngreso = cantIngreso;
    }

    @Column(name = "CANT_SALIDA", nullable = false)
    public float getCantSalida() {
        return cantSalida;
    }

    public void setCantSalida(float cantSalida) {
        this.cantSalida = cantSalida;
    }

    @Column(name = "AUTOPARTE", nullable = false)
    public boolean isAutoparte() {
        return autoparte;
    }

    public void setAutoparte(boolean autoparte) {
        this.autoparte = autoparte;
    }

    @Column(name = "SEG_CALIDAD", nullable = false)
    public boolean isSegCalidad() {
        return segCalidad;
    }

    public void setSegCalidad(boolean segCalidad) {
        this.segCalidad = segCalidad;
    }

    @Column(name = "ID_FAMILIA", nullable = false)
    public int getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(int idFamilia) {
        this.idFamilia = idFamilia;
    }

    @Column(name = "ID_SUBFAMILIA", nullable = false)
    public int getIdSubfamilia() {
        return idSubfamilia;
    }

    public void setIdSubfamilia(int idSubfamilia) {
        this.idSubfamilia = idSubfamilia;
    }

    @Column(name = "ID_USUARIO", nullable = false)
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
