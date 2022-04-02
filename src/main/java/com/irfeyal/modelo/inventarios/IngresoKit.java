package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.irfeyal.modelo.rolseguridad.RolUsuario;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "ingreso_kit")
@NamedQueries({
    @NamedQuery(name = "IngresoKit.findAll", query = "SELECT i FROM IngresoKit i"),
    @NamedQuery(name = "IngresoKit.findByid_ingreso_kid", query = "SELECT i FROM IngresoKit i WHERE i.id_ingreso_kid = :id_ingreso_kid"),
    @NamedQuery(name = "IngresoKit.findByFechaIngreso", query = "SELECT i FROM IngresoKit i WHERE i.fechaIngreso = :fechaIngreso")})
public class IngresoKit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ingreso_kid")
    private Long id_ingreso_kid;
    
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    @JoinColumn(name = "id_aprobacion", referencedColumnName = "id_aprobacion")
    @ManyToOne(optional = false)
    private Aprobacion id_aprobacion;
    
    @JoinColumn(name = "id_kid", referencedColumnName = "id_kid")
    @ManyToOne(optional = false)
    private Kit id_kid;
    
    @JoinColumn(name = "id_rol_usuario", referencedColumnName = "id_rol_usuario")
    @ManyToOne(optional = false)
    private RolUsuario id_rol_usuario;

    public IngresoKit() {
    }

    public IngresoKit(Long id_ingreso_kid) {
        this.id_ingreso_kid = id_ingreso_kid;
    }

    public Long getid_ingreso_kid() {
        return id_ingreso_kid;
    }

    public void setid_ingreso_kid(Long id_ingreso_kid) {
        this.id_ingreso_kid = id_ingreso_kid;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }


    public Aprobacion getId_aprobacion() {
		return id_aprobacion;
	}

	public void setId_aprobacion(Aprobacion id_aprobacion) {
		this.id_aprobacion = id_aprobacion;
	}

	public Kit getid_kid() {
        return id_kid;
    }

    public void setid_kid(Kit id_kid) {
        this.id_kid = id_kid;
    }

    public RolUsuario getid_rol_usuario() {
        return id_rol_usuario;
    }

    public void setid_rol_usuario(RolUsuario id_rol_usuario) {
        this.id_rol_usuario = id_rol_usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_ingreso_kid != null ? id_ingreso_kid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoKit)) {
            return false;
        }
        IngresoKit other = (IngresoKit) object;
        if ((this.id_ingreso_kid == null && other.id_ingreso_kid != null) || (this.id_ingreso_kid != null && !this.id_ingreso_kid.equals(other.id_ingreso_kid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.IngresoKit[ id_ingreso_kid=" + id_ingreso_kid + " ]";
    }
    
}
