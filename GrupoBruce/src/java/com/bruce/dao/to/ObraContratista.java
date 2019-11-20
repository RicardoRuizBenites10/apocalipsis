/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bruce.dao.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 *
 * @author SISTEMAS
 */
@Entity
@IdClass(value = ObraContratistaId.class)
@Table(name = "OBRA_CONTRATISTA", schema = "dbo", catalog = "BDBRUCE")
public class ObraContratista implements java.io.Serializable {

    private int idObra;
    private String idContratista;
    private String idEproceso;

    private String contratista;
    private String etapa;

    public ObraContratista() {
    }

    @Id
    @Column(name = "ID_OBRA", nullable = false)
    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    @Id
    @Column(name = "ID_CONTRATISTA", nullable = false)
    public String getIdContratista() {
        return idContratista;
    }

    public void setIdContratista(String idContratista) {
        this.idContratista = idContratista;
    }

    @Column(name = "ID_EPROCESO", nullable = false)
    public String getIdEproceso() {
        return idEproceso;
    }

    public void setIdEproceso(String idEproceso) {
        this.idEproceso = idEproceso;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "CONTRATISTA", insertable = false, updatable = false)
    public String getContratista() {
        return contratista;
    }

    public void setContratista(String contratista) {
        this.contratista = contratista;
    }

    @Generated(GenerationTime.NEVER)
    @Column(name = "ETAPA", insertable = false, updatable = false)
    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }
}
