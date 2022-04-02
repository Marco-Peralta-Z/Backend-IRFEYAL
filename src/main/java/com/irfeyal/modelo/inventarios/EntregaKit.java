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
@Table(name = "entrega_kit")
@NamedQueries({
    @NamedQuery(name = "EntregaKit.findAll", query = "SELECT e FROM EntregaKit e"),
    @NamedQuery(name = "EntregaKit.findByid_entrega_kid", query = "SELECT e FROM EntregaKit e WHERE e.id_entrega_kid = :id_entrega_kid"),
    @NamedQuery(name = "EntregaKit.findByFechaEntregaKit", query = "SELECT e FROM EntregaKit e WHERE e.fechaEntregaKit = :fechaEntregaKit")})
public class EntregaKit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entrega_kid")
    private Long id_entrega_kid;
    
    @Column(name = "fecha_entrega_kit")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaKit;
    
    @JoinColumn(name = "id_aprobacion", referencedColumnName = "id_aprobacion")
    @ManyToOne(optional = false)
    private Aprobacion id_aprobacion;
    
    @JoinColumn(name = "id_kid", referencedColumnName = "id_kid")
    @ManyToOne(optional = false)
    private Kit id_kid;
    
    @JoinColumn(name = "id_rol_usuario", referencedColumnName = "id_rol_usuario")
    @ManyToOne(optional = false)
    private RolUsuario id_rol_usuario;

    public EntregaKit() {
    }

    public EntregaKit(Long id_entrega_kid) {
        this.id_entrega_kid = id_entrega_kid;
    }

    public Long getid_entrega_kid() {
        return id_entrega_kid;
    }

    public void setid_entrega_kid(Long id_entrega_kid) {
        this.id_entrega_kid = id_entrega_kid;
    }

    public Date getFechaEntregaKit() {
        return fechaEntregaKit;
    }

    public void setFechaEntregaKit(Date fechaEntregaKit) {
        this.fechaEntregaKit = fechaEntregaKit;
    }

    public Aprobacion getid_aprobacion() {
        return id_aprobacion;
    }

    public void setid_aprobacion(Aprobacion id_aprobacion) {
        this.id_aprobacion = id_aprobacion;
    }

    public Kit getid_kid() {
        return id_kid;
    }

    public void setid_kid(Kit id_kid) {
        this.id_kid = id_kid;
    }

    public RolUsuario getId_rol_usuario() {
		return id_rol_usuario;
	}

	public void setId_rol_usuario(RolUsuario id_rol_usuario) {
		this.id_rol_usuario = id_rol_usuario;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id_entrega_kid != null ? id_entrega_kid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntregaKit)) {
            return false;
        }
        EntregaKit other = (EntregaKit) object;
        if ((this.id_entrega_kid == null && other.id_entrega_kid != null) || (this.id_entrega_kid != null && !this.id_entrega_kid.equals(other.id_entrega_kid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.EntregaKit[ id_entrega_kid=" + id_entrega_kid + " ]";
    }
    
}
