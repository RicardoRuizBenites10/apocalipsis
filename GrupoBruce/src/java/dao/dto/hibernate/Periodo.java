package dao.dto.hibernate;
// Generated 17/06/2018 01:48:57 PM by Hibernate Tools 4.3.1


import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Periodo generated by hbm2java
 */
@Entity
@Table(name="PERIODO"
    ,schema="dbo"
    ,catalog="BDBRUCE"
)
public class Periodo  implements java.io.Serializable {


     private int idPeriodo;
     private TipoPeriodo tipoPeriodo;
     private TipoTrabajador tipoTrabajador;
     private Date inicio;
     private Date fin;
     private Date iniPlame;
     private Date finPlame;
     private boolean situacion;
     private boolean cerrado;
     private Set<Vacacion> vacacions = new HashSet<Vacacion>(0);

    public Periodo() {
    }

	
    public Periodo(int idPeriodo, TipoPeriodo tipoPeriodo, Date inicio, Date fin, boolean situacion, boolean cerrado) {
        this.idPeriodo = idPeriodo;
        this.tipoPeriodo = tipoPeriodo;
        this.inicio = inicio;
        this.fin = fin;
        this.situacion = situacion;
        this.cerrado = cerrado;
    }
    public Periodo(int idPeriodo, TipoPeriodo tipoPeriodo, TipoTrabajador tipoTrabajador, Date inicio, Date fin, Date iniPlame, Date finPlame, boolean situacion, boolean cerrado, Set<Vacacion> vacacions) {
       this.idPeriodo = idPeriodo;
       this.tipoPeriodo = tipoPeriodo;
       this.tipoTrabajador = tipoTrabajador;
       this.inicio = inicio;
       this.fin = fin;
       this.iniPlame = iniPlame;
       this.finPlame = finPlame;
       this.situacion = situacion;
       this.cerrado = cerrado;
       this.vacacions = vacacions;
    }
   
     @Id 

    
    @Column(name="ID_PERIODO", unique=true, nullable=false)
    public int getIdPeriodo() {
        return this.idPeriodo;
    }
    
    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TPERIODO", nullable=false)
    public TipoPeriodo getTipoPeriodo() {
        return this.tipoPeriodo;
    }
    
    public void setTipoPeriodo(TipoPeriodo tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_TTRABAJADOR")
    public TipoTrabajador getTipoTrabajador() {
        return this.tipoTrabajador;
    }
    
    public void setTipoTrabajador(TipoTrabajador tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INICIO", nullable=false, length=10)
    public Date getInicio() {
        return this.inicio;
    }
    
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FIN", nullable=false, length=10)
    public Date getFin() {
        return this.fin;
    }
    
    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="INI_PLAME", length=10)
    public Date getIniPlame() {
        return this.iniPlame;
    }
    
    public void setIniPlame(Date iniPlame) {
        this.iniPlame = iniPlame;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FIN_PLAME", length=10)
    public Date getFinPlame() {
        return this.finPlame;
    }
    
    public void setFinPlame(Date finPlame) {
        this.finPlame = finPlame;
    }

    
    @Column(name="SITUACION", nullable=false)
    public boolean isSituacion() {
        return this.situacion;
    }
    
    public void setSituacion(boolean situacion) {
        this.situacion = situacion;
    }

    
    @Column(name="CERRADO", nullable=false)
    public boolean isCerrado() {
        return this.cerrado;
    }
    
    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="periodo")
    public Set<Vacacion> getVacacions() {
        return this.vacacions;
    }
    
    public void setVacacions(Set<Vacacion> vacacions) {
        this.vacacions = vacacions;
    }




}


