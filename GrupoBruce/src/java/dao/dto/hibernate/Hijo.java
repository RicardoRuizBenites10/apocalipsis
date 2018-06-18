package dao.dto.hibernate;
// Generated 17/06/2018 01:48:57 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Hijo generated by hbm2java
 */
@Entity
@Table(name="HIJO"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Hijo  implements java.io.Serializable {


     private int idHijo;
     private Genero genero;
     private Trabajador trabajador;
     private String dni;
     private Date nacimiento;
     private String nombres;

    public Hijo() {
    }

	
    public Hijo(int idHijo, Genero genero, Trabajador trabajador, Date nacimiento, String nombres) {
        this.idHijo = idHijo;
        this.genero = genero;
        this.trabajador = trabajador;
        this.nacimiento = nacimiento;
        this.nombres = nombres;
    }
    public Hijo(int idHijo, Genero genero, Trabajador trabajador, String dni, Date nacimiento, String nombres) {
       this.idHijo = idHijo;
       this.genero = genero;
       this.trabajador = trabajador;
       this.dni = dni;
       this.nacimiento = nacimiento;
       this.nombres = nombres;
    }
   
     @Id 

    
    @Column(name="ID_HIJO", unique=true, nullable=false)
    public int getIdHijo() {
        return this.idHijo;
    }
    
    public void setIdHijo(int idHijo) {
        this.idHijo = idHijo;
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
    @JoinColumn(name="ID_TRABAJADOR", nullable=false)
    public Trabajador getTrabajador() {
        return this.trabajador;
    }
    
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    
    @Column(name="DNI", length=8)
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="NACIMIENTO", nullable=false, length=10)
    public Date getNacimiento() {
        return this.nacimiento;
    }
    
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    
    @Column(name="NOMBRES", nullable=false, length=100)
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }




}


