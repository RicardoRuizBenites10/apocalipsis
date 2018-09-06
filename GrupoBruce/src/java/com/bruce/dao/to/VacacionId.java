package com.bruce.dao.to;
// Generated 06/09/2018 09:02:17 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VacacionId generated by hbm2java
 */
@Embeddable
public class VacacionId  implements java.io.Serializable {


     private String idTrabajador;
     private int idPeriodo;

    public VacacionId() {
    }

    public VacacionId(String idTrabajador, int idPeriodo) {
       this.idTrabajador = idTrabajador;
       this.idPeriodo = idPeriodo;
    }
   


    @Column(name="ID_TRABAJADOR", nullable=false, length=15)
    public String getIdTrabajador() {
        return this.idTrabajador;
    }
    
    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }


    @Column(name="ID_PERIODO", nullable=false)
    public int getIdPeriodo() {
        return this.idPeriodo;
    }
    
    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VacacionId) ) return false;
		 VacacionId castOther = ( VacacionId ) other; 
         
		 return ( (this.getIdTrabajador()==castOther.getIdTrabajador()) || ( this.getIdTrabajador()!=null && castOther.getIdTrabajador()!=null && this.getIdTrabajador().equals(castOther.getIdTrabajador()) ) )
 && (this.getIdPeriodo()==castOther.getIdPeriodo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdTrabajador() == null ? 0 : this.getIdTrabajador().hashCode() );
         result = 37 * result + this.getIdPeriodo();
         return result;
   }   


}


