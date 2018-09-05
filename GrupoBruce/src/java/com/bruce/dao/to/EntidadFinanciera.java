package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EntidadFinanciera generated by hbm2java
 */
@Entity
@Table(name = "ENTIDAD_FINANCIERA",
        schema = "dbo",
        catalog = "BDBRUCE"
)
public class EntidadFinanciera implements java.io.Serializable {

    private int idEfinanciera;
    private String codigo;
    private String nombre;
    private boolean situacion;
    private Set<CuentaCts> cuentaCtses = new HashSet<CuentaCts>(0);
    private Set<CuentaSueldo> cuentaSueldos = new HashSet<CuentaSueldo>(0);

    public EntidadFinanciera() {
    }

    public EntidadFinanciera(int idEfinanciera, String codigo, String nombre, boolean situacion) {
        this.idEfinanciera = idEfinanciera;
        this.codigo = codigo;
        this.nombre = nombre;
        this.situacion = situacion;
    }

    public EntidadFinanciera(int idEfinanciera, String codigo, String nombre, boolean situacion, Set<CuentaCts> cuentaCtses, Set<CuentaSueldo> cuentaSueldos) {
        this.idEfinanciera = idEfinanciera;
        this.codigo = codigo;
        this.nombre = nombre;
        this.situacion = situacion;
        this.cuentaCtses = cuentaCtses;
        this.cuentaSueldos = cuentaSueldos;
    }

    @Id

    @Column(name = "ID_EFINANCIERA", unique = true, nullable = false)
    public int getIdEfinanciera() {
        return this.idEfinanciera;
    }

    public void setIdEfinanciera(int idEfinanciera) {
        this.idEfinanciera = idEfinanciera;
    }

    @Column(name = "CODIGO", nullable = false, length = 3)
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name = "NOMBRE", nullable = false, length = 45)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "SITUACION", nullable = false)
    public boolean isSituacion() {
        return this.situacion;
    }

    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entidadFinanciera")
    public Set<CuentaCts> getCuentaCtses() {
        return this.cuentaCtses;
    }

    public void setCuentaCtses(Set<CuentaCts> cuentaCtses) {
        this.cuentaCtses = cuentaCtses;
    }

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entidadFinanciera")
    public Set<CuentaSueldo> getCuentaSueldos() {
        return this.cuentaSueldos;
    }

    public void setCuentaSueldos(Set<CuentaSueldo> cuentaSueldos) {
        this.cuentaSueldos = cuentaSueldos;
    }

}
