package com.bruce.dao.to;
// Generated 27/06/2018 10:09:26 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "USUARIO",
         schema = "dbo",
         catalog = "BDBRUCE"
)
public class Usuario implements java.io.Serializable {

    private String idUsuario;
    private Trabajador trabajador;
    private String usu;
    private byte[] clave;
    private boolean estado;
    private boolean acceder;
    private Set<Acceso> accesos = new HashSet<Acceso>(0);
    
    
    private String diClave;

    public Usuario() {
    }

    public Usuario(Trabajador trabajador, String usu, byte[] clave, boolean estado, boolean acceder) {
        this.trabajador = trabajador;
        this.usu = usu;
        this.clave = clave;
        this.estado = estado;
        this.acceder = acceder;
    }

    public Usuario(Trabajador trabajador, String usu, byte[] clave, boolean estado, boolean acceder, Set<Acceso> accesos) {
        this.trabajador = trabajador;
        this.usu = usu;
        this.clave = clave;
        this.estado = estado;
        this.acceder = acceder;
        this.accesos = accesos;
    }

    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "trabajador"))
    @Id
    @GeneratedValue(generator = "generator")

    @Column(name = "ID_USUARIO", unique = true, nullable = false, length = 15)
    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    public Trabajador getTrabajador() {
        return this.trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Column(name = "USU", nullable = false, length = 12)
    public String getUsu() {
        return this.usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    @Column(name = "CLAVE", nullable = false)
    @ColumnTransformer(write = "ENCRYPTBYPASSPHRASE('Bruces@22',?)", read = "DECRYPTBYPASSPHRASE('Bruces@22',CLAVE)")
    public byte[] getClave() {
        return this.clave;
    }

    public void setClave(byte[] clave) {
        this.clave = clave;
    }

    @Transient
    public String getDiClave() {
        return new String(clave);
    }

    public void setDiClave(String diClave) {
        this.diClave = diClave;
    }

    @Column(name = "ESTADO", nullable = false)
    public boolean isEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Column(name = "ACCEDER", nullable = false)
    public boolean isAcceder() {
        return this.acceder;
    }

    public void setAcceder(boolean acceder) {
        this.acceder = acceder;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Acceso> getAccesos() {
        return this.accesos;
    }

    public void setAccesos(Set<Acceso> accesos) {
        this.accesos = accesos;
    }
}
