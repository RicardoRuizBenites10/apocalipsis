package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AsistenciaId generated by hbm2java
 */
@Embeddable
public class AsistenciaId  implements java.io.Serializable {


     private String idTrabajador;
     private Date fecha;

    public AsistenciaId() {
    }

    public AsistenciaId(String idTrabajador, Date fecha) {
       this.idTrabajador = idTrabajador;
       this.fecha = fecha;
    }
   


    @Column(name="ID_TRABAJADOR", nullable=false, length=15)
    public String getIdTrabajador() {
        return this.idTrabajador;
    }
    
    public void setIdTrabajador(String idTrabajador) {
        this.idTrabajador = idTrabajador;
    }


    @Column(name="FECHA", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AsistenciaId) ) return false;
		 AsistenciaId castOther = ( AsistenciaId ) other; 
         
		 return ( (this.getIdTrabajador()==castOther.getIdTrabajador()) || ( this.getIdTrabajador()!=null && castOther.getIdTrabajador()!=null && this.getIdTrabajador().equals(castOther.getIdTrabajador()) ) )
 && ( (this.getFecha()==castOther.getFecha()) || ( this.getFecha()!=null && castOther.getFecha()!=null && this.getFecha().equals(castOther.getFecha()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdTrabajador() == null ? 0 : this.getIdTrabajador().hashCode() );
         result = 37 * result + ( getFecha() == null ? 0 : this.getFecha().hashCode() );
         return result;
   }   


}


