package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.Date;
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
    @Column(name = "id_entrega_kid")
    private Long id_entrega_kid;
    
    @Column(name = "fecha_entrega_kit")
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaKit;
    
    @JoinColumn(name = "id_aprobacion", referencedColumnName = "id_aprobacion")
    @ManyToOne(optional = false)
    private Aprobacion id_aprobacion;
    
    @JoinColumn(name = "id_kit", referencedColumnName = "id_kit")
    @ManyToOne(optional = false)
    private Kit id_kit;
    
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    @ManyToOne(optional = false)
    private Estudiante id_estudiante;

    public EntregaKit() {
    }

	public Long getId_entrega_kid() {
		return id_entrega_kid;
	}

	public void setId_entrega_kid(Long id_entrega_kid) {
		this.id_entrega_kid = id_entrega_kid;
	}

	public Date getFechaEntregaKit() {
		return fechaEntregaKit;
	}

	public void setFechaEntregaKit(Date fechaEntregaKit) {
		this.fechaEntregaKit = fechaEntregaKit;
	}

	public Aprobacion getId_aprobacion() {
		return id_aprobacion;
	}

	public void setId_aprobacion(Aprobacion id_aprobacion) {
		this.id_aprobacion = id_aprobacion;
	}

	public Kit getId_kit() {
		return id_kit;
	}

	public void setId_kit(Kit id_kit) {
		this.id_kit = id_kit;
	}

	public Estudiante getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Estudiante id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

    
}
