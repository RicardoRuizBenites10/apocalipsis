package com.bruce.dao.to;
// Generated 09/09/2018 05:31:05 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Menu generated by hbm2java
 */
@Entity
@Table(name = "MENU", schema = "dbo", catalog = "BDBRUCE")
public class Menu implements java.io.Serializable {

    private String idMenu;
    private String iconCls;
    private String text;
    private String handler;
    private boolean leaf;
    private String idSupmenu;
    private boolean proceso;
    private String codProceso;
    private String codEtapa;

    private String parentId;
    private String lastParentId;

    public Menu() {
    }

    public Menu(String idMenu, String iconCls, String text, String handler, String idSupmenu) {
        this.idMenu = idMenu;
        this.iconCls = iconCls;
        this.text = text;
        this.handler = handler;
        this.idSupmenu = idSupmenu;
    }

    @Id
    @Column(name = "ID_MENU", nullable = false)
    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    @Column(name = "ICON_CLS", nullable = false)
    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    @Column(name = "DESCRIPCION", nullable = false)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "ACCION", nullable = false)
    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Column(name = "LEAF", nullable = false)
    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    @Column(name = "ID_SUPMENU", nullable = false)
    public String getIdSupmenu() {
        return idSupmenu;
    }

    public void setIdSupmenu(String idSupmenu) {
        this.idSupmenu = idSupmenu;
    }

    @Column(name = "PROCESO", nullable = false)
    public boolean isProceso() {
        return proceso;
    }

    public void setProceso(boolean proceso) {
        this.proceso = proceso;
    }

    @Column(name = "COD_PROCESO")
    public String getCodProceso() {
        return codProceso;
    }

    public void setCodProceso(String codProceso) {
        this.codProceso = codProceso;
    }

    @Column(name = "COD_ETAPA")
    public String getCodEtapa() {
        return codEtapa;
    }

    public void setCodEtapa(String codEtapa) {
        this.codEtapa = codEtapa;
    }

    @Transient
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Transient
    public String getLastParentId() {
        return lastParentId;
    }

    public void setLastParentId(String lastParentId) {
        this.lastParentId = lastParentId;
    }

}
