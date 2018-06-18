package dao.dto.hibernate;
// Generated 17/06/2018 01:48:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Subarea generated by hbm2java
 */
@Entity
@Table(name="SUBAREA"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Subarea  implements java.io.Serializable {


     private int idSubarea;
     private Area area;
     private String nombre;
     private boolean situacion;
     private Set<Cargo> cargos = new HashSet<Cargo>(0);

    public Subarea() {
    }

	
    public Subarea(int idSubarea, Area area, String nombre, boolean situacion) {
        this.idSubarea = idSubarea;
        this.area = area;
        this.nombre = nombre;
        this.situacion = situacion;
    }
    public Subarea(int idSubarea, Area area, String nombre, boolean situacion, Set<Cargo> cargos) {
       this.idSubarea = idSubarea;
       this.area = area;
       this.nombre = nombre;
       this.situacion = situacion;
       this.cargos = cargos;
    }
   
     @Id 

    
    @Column(name="ID_SUBAREA", unique=true, nullable=false)
    public int getIdSubarea() {
        return this.idSubarea;
    }
    
    public void setIdSubarea(int idSubarea) {
        this.idSubarea = idSubarea;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_AREA", nullable=false)
    public Area getArea() {
        return this.area;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }

    
    @Column(name="NOMBRE", nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="subarea")
    public Set<Cargo> getCargos() {
        return this.cargos;
    }
    
    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }




}


