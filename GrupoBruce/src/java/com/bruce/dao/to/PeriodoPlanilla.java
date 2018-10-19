package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PeriodoPlanilla generated by hbm2java
 */
@Entity
@Table(name="PERIODO_PLANILLA" ,schema="dbo" ,catalog="BDBRUCE" )
public class PeriodoPlanilla  implements java.io.Serializable {

     private int idPeriodo;
     private Date inicio;
     private Date fin;
     private Date iniPlame;
     private Date finPlame;
     private boolean situacion;
     private boolean cerrado;
     private Integer idTtrabajador;

    public PeriodoPlanilla() {
    }

	
    public PeriodoPlanilla(int idPeriodo, Date inicio, Date fin, boolean situacion, boolean cerrado) {
        this.idPeriodo = idPeriodo;
        this.inicio = inicio;
        this.fin = fin;
        this.situacion = situacion;
        this.cerrado = cerrado;
    }
    public PeriodoPlanilla(int idPeriodo, Date inicio, Date fin, Date iniPlame, Date finPlame, boolean situacion, boolean cerrado, Integer idTtrabajador) {
       this.idPeriodo = idPeriodo;
       this.inicio = inicio;
       this.fin = fin;
       this.iniPlame = iniPlame;
       this.finPlame = finPlame;
       this.situacion = situacion;
       this.cerrado = cerrado;
       this.idTtrabajador = idTtrabajador;
    }
   
    @Id 
    @Column(name="ID_PERIODO", unique=true, nullable=false)
    public int getIdPeriodo() {
        return this.idPeriodo;
    }
    
    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
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
    
    @Column(name="ID_TTRABAJADOR")
    public Integer getIdTtrabajador() {
        return this.idTtrabajador;
    }
    
    public void setIdTtrabajador(Integer idTtrabajador) {
        this.idTtrabajador = idTtrabajador;
    }




}

