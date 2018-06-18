package dao.dto.hibernate;
// Generated 17/06/2018 01:48:57 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persona generated by hbm2java
 */
@Entity
@Table(name="PERSONA"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Persona  implements java.io.Serializable {


     private String dni;
     private Ecivil ecivil;
     private Genero genero;
     private TipoDocumento tipoDocumento;
     private String foto;
     private String apPaterno;
     private String apMaterno;
     private String nombres;
     private Date nacimiento;
     private String direccion;
     private String telefono;
     private int nroHijos;
     private String referencia;
     private Trabajador trabajador;

    public Persona() {
    }

	
    public Persona(String dni, Ecivil ecivil, Genero genero, TipoDocumento tipoDocumento, String apPaterno, String apMaterno, String nombres, Date nacimiento, String direccion, String telefono, int nroHijos) {
        this.dni = dni;
        this.ecivil = ecivil;
        this.genero = genero;
        this.tipoDocumento = tipoDocumento;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.nombres = nombres;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nroHijos = nroHijos;
    }
    public Persona(String dni, Ecivil ecivil, Genero genero, TipoDocumento tipoDocumento, String foto, String apPaterno, String apMaterno, String nombres, Date nacimiento, String direccion, String telefono, int nroHijos, String referencia, Trabajador trabajador) {
       this.dni = dni;
       this.ecivil = ecivil;
       this.genero = genero;
       this.tipoDocumento = tipoDocumento;
       this.foto = foto;
       this.apPaterno = apPaterno;
       this.apMaterno = apMaterno;
       this.nombres = nombres;
       this.nacimiento = nacimiento;
       this.direccion = direccion;
       this.telefono = telefono;
       this.nroHijos = nroHijos;
       this.referencia = referencia;
       this.trabajador = trabajador;
    }
   
     @Id 

    
    @Column(name="DNI", unique=true, nullable=false, length=15)
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_ECIVIL", nullable=false)
    public Ecivil getEcivil() {
        return this.ecivil;
    }
    
    public void setEcivil(Ecivil ecivil) {
        this.ecivil = ecivil;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_GENERO", nullable=false)
    public Genero getGenero() {
        return this.genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TDOCUMENTO", nullable=false)
    public TipoDocumento getTipoDocumento() {
        return this.tipoDocumento;
    }
    
    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    
    @Column(name="FOTO", length=50)
    public String getFoto() {
        return this.foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }

    
    @Column(name="AP_PATERNO", nullable=false, length=25)
    public String getApPaterno() {
        return this.apPaterno;
    }
    
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    
    @Column(name="AP_MATERNO", nullable=false, length=25)
    public String getApMaterno() {
        return this.apMaterno;
    }
    
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    
    @Column(name="NOMBRES", nullable=false, length=50)
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="NACIMIENTO", nullable=false, length=10)
    public Date getNacimiento() {
        return this.nacimiento;
    }
    
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    
    @Column(name="DIRECCION", nullable=false, length=100)
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    @Column(name="TELEFONO", nullable=false, length=15)
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    @Column(name="NRO_HIJOS", nullable=false)
    public int getNroHijos() {
        return this.nroHijos;
    }
    
    public void setNroHijos(int nroHijos) {
        this.nroHijos = nroHijos;
    }

    
    @Column(name="REFERENCIA", length=200)
    public String getReferencia() {
        return this.referencia;
    }
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

@OneToOne(fetch=FetchType.LAZY, mappedBy="persona")
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }




}


