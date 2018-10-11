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
 * Hijo generated by hbm2java
 */
@Entity
@Table(name = "HIJO",
        schema = "dbo",
        catalog = "BDBRUCE"
)
@IdClass(value = HijoId.class)
public class Hijo implements java.io.Serializable {

    private String idTrabajador;
    private int idHijo;
    private String dni;
    private Date nacimiento;
    private String nombres;
    private int idGenero;

    public Hijo() {
    }

    public Hijo(int idHijo, Date nacimiento, String nombres, int idGenero, String idTrabajador) {
        this.idHijo = idHijo;
        this.nacimiento = nacimiento;
        this.nombres = nombres;
        this.idGenero = idGenero;
        this.idTrabajador = idTrabajador;
    }

    public Hijo(int idHijo, String dni, Date nacimiento, String nombres, int idGenero, String idTrabajador) {
        this.idHijo = idHijo;
        this.dni = dni;
        this.nacimiento = nacimiento;
        this.nombres = nombres;
        this.idGenero = idGenero;
        this.idTrabajador = idTrabajador;
    }

    @Id
    @Column(name = "ID_TRABAJADOR", nullable = false, length = 15)
    public String getIdTrabajador() {
        return this.idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Id
    @Column(name = "ID_HIJO", nullable = false)
    public int getIdHijo() {
        return this.idHijo;
    }

    public void setIdHijo(int idHijo) {
        this.idHijo = idHijo;
    }

    @Column(name = "DNI", length = 8)
    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "NACIMIENTO", nullable = false, length = 10)
    public Date getNacimiento() {
        return this.nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Column(name = "NOMBRES", nullable = false, length = 100)
    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Column(name = "ID_GENERO", nullable = false)
    public int getIdGenero() {
        return this.idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

}
