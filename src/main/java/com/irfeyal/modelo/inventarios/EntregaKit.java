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

import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.rolseguridad.Empleado;
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
    
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Estudiante id_estudiante;

    public EntregaKit() {
    }

    
    public EntregaKit(Long id_entrega_kid, Date fechaEntregaKit, Aprobacion id_aprobacion, Kit id_kid,
			Estudiante id_estudiante) {
		super();
		this.id_entrega_kid = id_entrega_kid;
		this.fechaEntregaKit = fechaEntregaKit;
		this.id_aprobacion = id_aprobacion;
		this.id_kid = id_kid;
		this.id_estudiante = id_estudiante;
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

    

	public Long getId_entrega_kid() {
		return id_entrega_kid;
	}

	public void setId_entrega_kid(Long id_entrega_kid) {
		this.id_entrega_kid = id_entrega_kid;
	}

	public Aprobacion getId_aprobacion() {
		return id_aprobacion;
	}

	public void setId_aprobacion(Aprobacion id_aprobacion) {
		this.id_aprobacion = id_aprobacion;
	}

	public Kit getId_kid() {
		return id_kid;
	}

	public void setId_kid(Kit id_kid) {
		this.id_kid = id_kid;
	}

	
	
	
	
	public Estudiante getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Estudiante id_estudiante) {
		this.id_estudiante = id_estudiante;
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
