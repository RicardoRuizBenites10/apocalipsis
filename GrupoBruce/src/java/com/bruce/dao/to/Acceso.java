
package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * Acceso generated by hbm2java
 */
@Entity
@Table(name = "ACCESO", schema = "dbo", catalog = "BDBRUCE")
@IdClass(value = AccesoId.class)
public class Acceso implements java.io.Serializable {

    private String idMenu;
    private String idRol;
    private Date fechaUpdate;
    private boolean checked;
    
    private String idSupmenu;
    private boolean leaf;
    private String text;
    private String iconCls;
    private String handler;
    private boolean proceso;
    private String codProceso;
    private String parentId;

    public Acceso() {
    }

    public Acceso(String idMenu, String idRol, Date fechaUpdate, boolean checked) {
        this.idMenu = idMenu;
        this.idRol = idRol;
        this.fechaUpdate = fechaUpdate;
        this.checked = checked;
    }
    
    @Id
    @Column(name="ID_MENU", nullable=false)
    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }
    
    @Id
    @Column(name="ID_ROL", nullable=false)
    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_UPDATE", nullable=false)
    public Date getFechaUpdate() {
        return fechaUpdate;
    }

    public void setFechaUpdate(Date fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    @Column(name="ACCEDER", nullable=false)
    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    @Generated(GenerationTime.NEVER) 
    @Column(insertable = false, updatable = false)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Generated(GenerationTime.NEVER) 
    @Column(insertable = false, updatable = false)
    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @Generated(GenerationTime.NEVER) 
    @Column(insertable = false, updatable = false)
    public String getIdSupmenu() {
        return idSupmenu;
    }

    public void setIdSupmenu(String idSupmenu) {
        this.idSupmenu = idSupmenu;
    }
        
    @Generated(GenerationTime.NEVER) 
    @Column(insertable = false, updatable = false)
    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    @Generated(GenerationTime.NEVER) 
    @Column(name = "ACCION",insertable = false, updatable = false)
    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Generated(GenerationTime.NEVER) 
    @Column(name = "PROCESO",insertable = false, updatable = false)
    public boolean isProceso() {
        return proceso;
    }

    public void setProceso(boolean proceso) {
        this.proceso = proceso;
    }

    @Generated(GenerationTime.NEVER) 
    @Column(name = "COD_PROCESO",insertable = false, updatable = false)
    public String getCodProceso() {
        return codProceso;
    }

    public void setCodProceso(String codProceso) {
        this.codProceso = codProceso;
    }

    @Transient
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
