package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import com.bruce.util.Metodo;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Trabajador generated by hbm2java
 */
@Entity
@Table(name = "TRABAJADOR",
        schema = "dbo",
        catalog = "BDBRUCE"
)
public class Trabajador implements java.io.Serializable {

    private String idTrabajador;
    private String foto;
    private String apPaterno;
    private String apMaterno;
    private String nombres;
    private Date nacimiento;
    private String direccion;
    private String telefono;
    private int nroHijos;
    private String referencia;
    private String codigo;
    private double montoBase;
    private Double montoPasaje;
    private String nrocuentaSueldo;
    private String nrocuentaCts;
    private String nrocusppAfiliacion;
    private Date ultimaAlta;

    private int idNacionalidad;
    private String idTdocumento;
    private int idGenero;
    private int idEcivil;
    private int idTtrabajador;
    private int idEtrabajador;
    private int idFpago;
    private int idPeriocidad;
    private String idEmpresa;
    private String idSucursal;
    private String idEfSueldo;
    private String idEfCts;
    private String idRpensionario;
    private Integer idComisionrp;

    private String fotoB64; //quitado hasta terminar de mapear clases para json

    public Trabajador() {
    }

    public Trabajador(String idTrabajador, String apPaterno, String apMaterno, String nombres, Date nacimiento, String direccion, String telefono, int nroHijos, String codigo, double montoBase, int idNacionalidad, String idTdocumento, int idGenero, int idEcivil, int idTtrabajador, int idEtrabajador, int idFpago, int idPeriocidad, String idEmpresa, String idSucursal) {
        this.idTrabajador = idTrabajador;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.nombres = nombres;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nroHijos = nroHijos;
        this.codigo = codigo;
        this.montoBase = montoBase;
        this.idNacionalidad = idNacionalidad;
        this.idTdocumento = idTdocumento;
        this.idGenero = idGenero;
        this.idEcivil = idEcivil;
        this.idTtrabajador = idTtrabajador;
        this.idEtrabajador = idEtrabajador;
        this.idFpago = idFpago;
        this.idPeriocidad = idPeriocidad;
        this.idEmpresa = idEmpresa;
        this.idSucursal = idSucursal;
    }

    public Trabajador(String idTrabajador, String foto, String apPaterno, String apMaterno, String nombres, Date nacimiento, String direccion, String telefono, int nroHijos, String referencia, String codigo, double montoBase, Double montoPasaje, String nrocuentaSueldo, String nrocuentaCts, String nrocusppAfiliacion, Date ultimaAlta, int idNacionalidad, String idTdocumento, int idGenero, int idEcivil, int idTtrabajador, int idEtrabajador, int idFpago, int idPeriocidad, String idEmpresa, String idSucursal, String idEfSueldo, String idEfCts, String idRpensionario, Integer idComisionrp) {
        this.idTrabajador = idTrabajador;
        this.foto = foto;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.nombres = nombres;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nroHijos = nroHijos;
        this.referencia = referencia;
        this.codigo = codigo;
        this.montoBase = montoBase;
        this.montoPasaje = montoPasaje;
        this.nrocuentaSueldo = nrocuentaSueldo;
        this.nrocuentaCts = nrocuentaCts;
        this.nrocusppAfiliacion = nrocusppAfiliacion;
        this.ultimaAlta = ultimaAlta;
        this.idNacionalidad = idNacionalidad;
        this.idTdocumento = idTdocumento;
        this.idGenero = idGenero;
        this.idEcivil = idEcivil;
        this.idTtrabajador = idTtrabajador;
        this.idEtrabajador = idEtrabajador;
        this.idFpago = idFpago;
        this.idPeriocidad = idPeriocidad;
        this.idEmpresa = idEmpresa;
        this.idSucursal = idSucursal;
        this.idEfSueldo = idEfSueldo;
        this.idEfCts = idEfCts;
        this.idRpensionario = idRpensionario;
        this.idComisionrp = idComisionrp;
    }

    @Id
    @Column(name = "ID_TRABAJADOR", unique = true, nullable = false, length = 15)
    public String getIdTrabajador() {
        return this.idTrabajador;
    }

    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Column(name = "FOTO", length = 50)
    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Transient
    public String getFotoB64() {
        return Metodo.getAvatarB64(this.idTrabajador, this.foto);
    }

    public void setFotoB64(String fotoB64) {
        this.fotoB64 = fotoB64;
    }

    @Column(name = "AP_PATERNO", nullable = false, length = 25)
    public String getApPaterno() {
        return this.apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    @Column(name = "AP_MATERNO", nullable = false, length = 25)
    public String getApMaterno() {
        return this.apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    @Column(name = "NOMBRES", nullable = false, length = 50)
    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "NACIMIENTO", nullable = false, length = 10)
    public Date getNacimiento() {
        return this.nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Column(name = "DIRECCION", nullable = false, length = 100)
    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "TELEFONO", nullable = false, length = 15)
    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Column(name = "NRO_HIJOS", nullable = false)
    public int getNroHijos() {
        return this.nroHijos;
    }

    public void setNroHijos(int nroHijos) {
        this.nroHijos = nroHijos;
    }

    @Column(name = "REFERENCIA", length = 200)
    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Column(name = "CODIGO", nullable = false, length = 10)
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name = "MONTO_BASE", nullable = false, precision = 53, scale = 0)
    public double getMontoBase() {
        return this.montoBase;
    }

    public void setMontoBase(double montoBase) {
        this.montoBase = montoBase;
    }

    @Column(name = "MONTO_PASAJE", precision = 53, scale = 0)
    public Double getMontoPasaje() {
        return this.montoPasaje;
    }

    public void setMontoPasaje(Double montoPasaje) {
        this.montoPasaje = montoPasaje;
    }

    @Column(name = "NROCUENTA_SUELDO", length = 25)
    public String getNrocuentaSueldo() {
        return this.nrocuentaSueldo;
    }

    public void setNrocuentaSueldo(String nrocuentaSueldo) {
        this.nrocuentaSueldo = nrocuentaSueldo;
    }

    @Column(name = "NROCUENTA_CTS", length = 25)
    public String getNrocuentaCts() {
        return this.nrocuentaCts;
    }

    public void setNrocuentaCts(String nrocuentaCts) {
        this.nrocuentaCts = nrocuentaCts;
    }

    @Column(name = "NROCUSPP_AFILIACION", length = 15)
    public String getNrocusppAfiliacion() {
        return this.nrocusppAfiliacion;
    }

    public void setNrocusppAfiliacion(String nrocusppAfiliacion) {
        this.nrocusppAfiliacion = nrocusppAfiliacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "ULTIMA_ALTA", length = 10)
    public Date getUltimaAlta() {
        return ultimaAlta;
    }

    public void setUltimaAlta(Date ultimaAlta) {
        this.ultimaAlta = ultimaAlta;
    }

    @Column(name = "ID_NACIONALIDAD", nullable = false)
    public int getIdNacionalidad() {
        return this.idNacionalidad;
    }

    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    @Column(name = "ID_TDOCUMENTO", nullable = false, length = 2)
    public String getIdTdocumento() {
        return this.idTdocumento;
    }

    public void setIdTdocumento(String idTdocumento) {
        this.idTdocumento = idTdocumento;
    }

    @Column(name = "ID_GENERO", nullable = false)
    public int getIdGenero() {
        return this.idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    @Column(name = "ID_ECIVIL", nullable = false)
    public int getIdEcivil() {
        return this.idEcivil;
    }

    public void setIdEcivil(int idEcivil) {
        this.idEcivil = idEcivil;
    }

    @Column(name = "ID_TTRABAJADOR", nullable = false)
    public int getIdTtrabajador() {
        return this.idTtrabajador;
    }

    public void setIdTtrabajador(int idTtrabajador) {
        this.idTtrabajador = idTtrabajador;
    }

    @Column(name = "ID_ETRABAJADOR", nullable = false)
    public int getIdEtrabajador() {
        return this.idEtrabajador;
    }

    public void setIdEtrabajador(int idEtrabajador) {
        this.idEtrabajador = idEtrabajador;
    }

    @Column(name = "ID_FPAGO", nullable = false)
    public int getIdFpago() {
        return this.idFpago;
    }

    public void setIdFpago(int idFpago) {
        this.idFpago = idFpago;
    }

    @Column(name = "ID_PERIOCIDAD", nullable = false)
    public int getIdPeriocidad() {
        return this.idPeriocidad;
    }

    public void setIdPeriocidad(int idPeriocidad) {
        this.idPeriocidad = idPeriocidad;
    }

    @Column(name = "ID_EMPRESA", nullable = false, length = 2)
    public String getIdEmpresa() {
        return this.idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Column(name = "ID_SUCURSAL", nullable = false, length = 2)
    public String getIdSucursal() {
        return this.idSucursal;
    }

    public void setIdSucursal(String idSucursal) {
        this.idSucursal = idSucursal;
    }

    @Column(name = "ID_EF_SUELDO", length = 3)
    public String getIdEfSueldo() {
        return this.idEfSueldo;
    }

    public void setIdEfSueldo(String idEfSueldo) {
        this.idEfSueldo = idEfSueldo;
    }

    @Column(name = "ID_EF_CTS", length = 3)
    public String getIdEfCts() {
        return this.idEfCts;
    }

    public void setIdEfCts(String idEfCts) {
        this.idEfCts = idEfCts;
    }

    @Column(name = "ID_RPENSIONARIO", length = 2)
    public String getIdRpensionario() {
        return this.idRpensionario;
    }

    public void setIdRpensionario(String idRpensionario) {
        this.idRpensionario = idRpensionario;
    }

    @Column(name = "ID_COMISIONRP")
    public Integer getIdComisionrp() {
        return this.idComisionrp;
    }

    public void setIdComisionrp(Integer idComisionrp) {
        this.idComisionrp = idComisionrp;
    }

}
