package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Trabajador generated by hbm2java
 */
@Entity
@Table(name="TRABAJADOR"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Trabajador  implements java.io.Serializable {


     private String idTrabajador;
     private EstadoTrabajador estadoTrabajador;
     private FormaPago formaPago;
     private Nacionalidad nacionalidad;
     private Periocidad periocidad;
     private Persona persona;
     private Sucursal sucursal;
     private TipoTrabajador tipoTrabajador;
     private boolean asignacion;
     private String codigo;
     private double montoBase;
     private Double montoPasaje;
     private Set<Afiliacion> afiliacions = new HashSet<Afiliacion>(0);
     private Set<EntradaSalida> entradaSalidas = new HashSet<EntradaSalida>(0);
     private Set<ContratoTrabajador> contratoTrabajadors = new HashSet<ContratoTrabajador>(0);
     private Set<Vacacion> vacacions = new HashSet<Vacacion>(0);
     private CuentaSueldo cuentaSueldo;
     private Set<Hijo> hijos = new HashSet<Hijo>(0);
     private Set<AlmuerzoTrabajador> almuerzoTrabajadors = new HashSet<AlmuerzoTrabajador>(0);
     private Set<Asistencia> asistencias = new HashSet<Asistencia>(0);
     private CuentaCts cuentaCts;
     private Set<Formacion> formacions = new HashSet<Formacion>(0);
     private Set<Permiso> permisos = new HashSet<Permiso>(0);
     private Set<Textralaboral> textralaborals = new HashSet<Textralaboral>(0);
     private Usuario usuario;

    public Trabajador() {
    }

	
    public Trabajador(EstadoTrabajador estadoTrabajador, FormaPago formaPago, Nacionalidad nacionalidad, Periocidad periocidad, Persona persona, Sucursal sucursal, TipoTrabajador tipoTrabajador, boolean asignacion, String codigo, double montoBase) {
        this.estadoTrabajador = estadoTrabajador;
        this.formaPago = formaPago;
        this.nacionalidad = nacionalidad;
        this.periocidad = periocidad;
        this.persona = persona;
        this.sucursal = sucursal;
        this.tipoTrabajador = tipoTrabajador;
        this.asignacion = asignacion;
        this.codigo = codigo;
        this.montoBase = montoBase;
    }
    public Trabajador(EstadoTrabajador estadoTrabajador, FormaPago formaPago, Nacionalidad nacionalidad, Periocidad periocidad, Persona persona, Sucursal sucursal, TipoTrabajador tipoTrabajador, boolean asignacion, String codigo, double montoBase, Double montoPasaje, Set<Afiliacion> afiliacions, Set<EntradaSalida> entradaSalidas, Set<ContratoTrabajador> contratoTrabajadors, Set<Vacacion> vacacions, CuentaSueldo cuentaSueldo, Set<Hijo> hijos, Set<AlmuerzoTrabajador> almuerzoTrabajadors, Set<Asistencia> asistencias, CuentaCts cuentaCts, Set<Formacion> formacions, Set<Permiso> permisos, Set<Textralaboral> textralaborals, Usuario usuario) {
       this.estadoTrabajador = estadoTrabajador;
       this.formaPago = formaPago;
       this.nacionalidad = nacionalidad;
       this.periocidad = periocidad;
       this.persona = persona;
       this.sucursal = sucursal;
       this.tipoTrabajador = tipoTrabajador;
       this.asignacion = asignacion;
       this.codigo = codigo;
       this.montoBase = montoBase;
       this.montoPasaje = montoPasaje;
       this.afiliacions = afiliacions;
       this.entradaSalidas = entradaSalidas;
       this.contratoTrabajadors = contratoTrabajadors;
       this.vacacions = vacacions;
       this.cuentaSueldo = cuentaSueldo;
       this.hijos = hijos;
       this.almuerzoTrabajadors = almuerzoTrabajadors;
       this.asistencias = asistencias;
       this.cuentaCts = cuentaCts;
       this.formacions = formacions;
       this.permisos = permisos;
       this.textralaborals = textralaborals;
       this.usuario = usuario;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="persona"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="ID_TRABAJADOR", unique=true, nullable=false, length=15)
    public String getIdTrabajador() {
        return this.idTrabajador;
    }
    
    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_ETRABAJADOR", nullable=false)
    public EstadoTrabajador getEstadoTrabajador() {
        return this.estadoTrabajador;
    }
    
    public void setEstadoTrabajador(EstadoTrabajador estadoTrabajador) {
        this.estadoTrabajador = estadoTrabajador;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_FPAGO", nullable=false)
    public FormaPago getFormaPago() {
        return this.formaPago;
    }
    
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_NACIONALIDAD", nullable=false)
    public Nacionalidad getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_PERIOCIDAD", nullable=false)
    public Periocidad getPeriocidad() {
        return this.periocidad;
    }
    
    public void setPeriocidad(Periocidad periocidad) {
        this.periocidad = periocidad;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_SUCURSAL", nullable=false)
    public Sucursal getSucursal() {
        return this.sucursal;
    }
    
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TTRABAJADOR", nullable=false)
    public TipoTrabajador getTipoTrabajador() {
        return this.tipoTrabajador;
    }
    
    public void setTipoTrabajador(TipoTrabajador tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    
    @Column(name="ASIGNACION", nullable=false)
    public boolean isAsignacion() {
        return this.asignacion;
    }
    
    public void setAsignacion(boolean asignacion) {
        this.asignacion = asignacion;
    }

    
    @Column(name="CODIGO", nullable=false, length=10)
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="MONTO_BASE", nullable=false, precision=53, scale=0)
    public double getMontoBase() {
        return this.montoBase;
    }
    
    public void setMontoBase(double montoBase) {
        this.montoBase = montoBase;
    }

    
    @Column(name="MONTO_PASAJE", precision=53, scale=0)
    public Double getMontoPasaje() {
        return this.montoPasaje;
    }
    
    public void setMontoPasaje(Double montoPasaje) {
        this.montoPasaje = montoPasaje;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Set<Afiliacion> getAfiliacions() {
        return this.afiliacions;
    }
    
    public void setAfiliacions(Set<Afiliacion> afiliacions) {
        this.afiliacions = afiliacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Set<EntradaSalida> getEntradaSalidas() {
        return this.entradaSalidas;
    }
    
    public void setEntradaSalidas(Set<EntradaSalida> entradaSalidas) {
        this.entradaSalidas = entradaSalidas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Set<ContratoTrabajador> getContratoTrabajadors() {
        return this.contratoTrabajadors;
    }
    
    public void setContratoTrabajadors(Set<ContratoTrabajador> contratoTrabajadors) {
        this.contratoTrabajadors = contratoTrabajadors;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Set<Vacacion> getVacacions() {
        return this.vacacions;
    }
    
    public void setVacacions(Set<Vacacion> vacacions) {
        this.vacacions = vacacions;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="trabajador")
    public CuentaSueldo getCuentaSueldo() {
        return this.cuentaSueldo;
    }
    
    public void setCuentaSueldo(CuentaSueldo cuentaSueldo) {
        this.cuentaSueldo = cuentaSueldo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Set<Hijo> getHijos() {
        return this.hijos;
    }
    
    public void setHijos(Set<Hijo> hijos) {
        this.hijos = hijos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Set<AlmuerzoTrabajador> getAlmuerzoTrabajadors() {
        return this.almuerzoTrabajadors;
    }
    
    public void setAlmuerzoTrabajadors(Set<AlmuerzoTrabajador> almuerzoTrabajadors) {
        this.almuerzoTrabajadors = almuerzoTrabajadors;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Set<Asistencia> getAsistencias() {
        return this.asistencias;
    }
    
    public void setAsistencias(Set<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="trabajador")
    public CuentaCts getCuentaCts() {
        return this.cuentaCts;
    }
    
    public void setCuentaCts(CuentaCts cuentaCts) {
        this.cuentaCts = cuentaCts;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Set<Formacion> getFormacions() {
        return this.formacions;
    }
    
    public void setFormacions(Set<Formacion> formacions) {
        this.formacions = formacions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Set<Permiso> getPermisos() {
        return this.permisos;
    }
    
    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Set<Textralaboral> getTextralaborals() {
        return this.textralaborals;
    }
    
    public void setTextralaborals(Set<Textralaboral> textralaborals) {
        this.textralaborals = textralaborals;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="trabajador")
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }




}


