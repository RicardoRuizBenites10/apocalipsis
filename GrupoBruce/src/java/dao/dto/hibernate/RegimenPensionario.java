package dao.dto.hibernate;
// Generated 17/06/2018 01:48:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RegimenPensionario generated by hbm2java
 */
@Entity
@Table(name="REGIMEN_PENSIONARIO"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class RegimenPensionario  implements java.io.Serializable {


     private int idRpensionario;
     private String codigo;
     private String descripcion;
     private boolean cuspp;
     private boolean situacion;
     private Set<Afiliacion> afiliacions = new HashSet<Afiliacion>(0);

    public RegimenPensionario() {
    }

	
    public RegimenPensionario(int idRpensionario, String codigo, boolean cuspp, boolean situacion) {
        this.idRpensionario = idRpensionario;
        this.codigo = codigo;
        this.cuspp = cuspp;
        this.situacion = situacion;
    }
    public RegimenPensionario(int idRpensionario, String codigo, String descripcion, boolean cuspp, boolean situacion, Set<Afiliacion> afiliacions) {
       this.idRpensionario = idRpensionario;
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.cuspp = cuspp;
       this.situacion = situacion;
       this.afiliacions = afiliacions;
    }
   
     @Id 

    
    @Column(name="ID_RPENSIONARIO", unique=true, nullable=false)
    public int getIdRpensionario() {
        return this.idRpensionario;
    }
    
    public void setIdRpensionario(int idRpensionario) {
        this.idRpensionario = idRpensionario;
    }

    
    @Column(name="CODIGO", nullable=false, length=3)
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="DESCRIPCION", length=50)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="CUSPP", nullable=false)
    public boolean isCuspp() {
        return this.cuspp;
    }
    
    public void setCuspp(boolean cuspp) {
        this.cuspp = cuspp;
    }

    
    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="regimenPensionario")
    public Set<Afiliacion> getAfiliacions() {
        return this.afiliacions;
    }
    
    public void setAfiliacions(Set<Afiliacion> afiliacions) {
        this.afiliacions = afiliacions;
    }




}


