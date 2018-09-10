package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ContratoTrabajadorId generated by hbm2java
 */
@Embeddable
public class ContratoTrabajadorId  implements java.io.Serializable {


     private String idTrabajador;
     private int idContrato;

    public ContratoTrabajadorId() {
    }

    public ContratoTrabajadorId(String idTrabajador, int idContrato) {
       this.idTrabajador = idTrabajador;
       this.idContrato = idContrato;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ContratoTrabajadorId) ) return false;
		 ContratoTrabajadorId castOther = ( ContratoTrabajadorId ) other; 
         
		 return ( (this.getIdTrabajador()==castOther.getIdTrabajador()) || ( this.getIdTrabajador()!=null && castOther.getIdTrabajador()!=null && this.getIdTrabajador().equals(castOther.getIdTrabajador()) ) )
 && (this.getIdContrato()==castOther.getIdContrato());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdTrabajador() == null ? 0 : this.getIdTrabajador().hashCode() );
         result = 37 * result + this.getIdContrato();
         return result;
   }   


}


