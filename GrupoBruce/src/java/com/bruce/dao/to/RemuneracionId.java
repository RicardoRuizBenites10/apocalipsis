package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RemuneracionId generated by hbm2java
 */
@Embeddable
public class RemuneracionId  implements java.io.Serializable {


     private String idTrabajador;
     private int idContrato;
     private int idRemuneracion;

    public RemuneracionId() {
    }

    public RemuneracionId(String idTrabajador, int idContrato, int idRemuneracion) {
       this.idTrabajador = idTrabajador;
       this.idContrato = idContrato;
       this.idRemuneracion = idRemuneracion;
    }
   


    @Column(name="ID_TRABAJADOR", nullable=false, length=15)
    public String getIdTrabajador() {
        return this.idTrabajador;
    }
    
    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }


    @Column(name="ID_CONTRATO", nullable=false)
    public int getIdContrato() {
        return this.idContrato;
    }
    
    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }


    @Column(name="ID_REMUNERACION", nullable=false)
    public int getIdRemuneracion() {
        return this.idRemuneracion;
    }
    
    public void setIdRemuneracion(int idRemuneracion) {
        this.idRemuneracion = idRemuneracion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RemuneracionId) ) return false;
		 RemuneracionId castOther = ( RemuneracionId ) other; 
         
		 return ( (this.getIdTrabajador()==castOther.getIdTrabajador()) || ( this.getIdTrabajador()!=null && castOther.getIdTrabajador()!=null && this.getIdTrabajador().equals(castOther.getIdTrabajador()) ) )
 && (this.getIdContrato()==castOther.getIdContrato())
 && (this.getIdRemuneracion()==castOther.getIdRemuneracion());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdTrabajador() == null ? 0 : this.getIdTrabajador().hashCode() );
         result = 37 * result + this.getIdContrato();
         result = 37 * result + this.getIdRemuneracion();
         return result;
   }   


}


