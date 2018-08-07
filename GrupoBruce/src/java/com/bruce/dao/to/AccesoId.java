package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AccesoId generated by hbm2java
 */
@Embeddable
public class AccesoId implements java.io.Serializable {

    private String idUsuario;
    private int idMenu;

    public AccesoId() {
    }

    public AccesoId(String idUsuario, int idMenu) {
        this.idUsuario = idUsuario;
        this.idMenu = idMenu;
    }

    @Column(name = "ID_USUARIO", nullable = false, length = 15)
    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Column(name = "ID_MENU", nullable = false)
    public int getIdMenu() {
        return this.idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof AccesoId)) {
            return false;
        }
        AccesoId castOther = (AccesoId) other;

        return ((this.getIdUsuario() == castOther.getIdUsuario()) || (this.getIdUsuario() != null && castOther.getIdUsuario() != null && this.getIdUsuario().equals(castOther.getIdUsuario())))
                && (this.getIdMenu() == castOther.getIdMenu());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getIdUsuario() == null ? 0 : this.getIdUsuario().hashCode());
        result = 37 * result + this.getIdMenu();
        return result;
    }

}
