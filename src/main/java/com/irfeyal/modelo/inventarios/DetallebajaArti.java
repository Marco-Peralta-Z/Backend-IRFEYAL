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

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "detalle_baja_arti")
public class DetallebajaArti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_det_baja_art")
    private Long id_det_baja_art;
  
    @Column(name = "motivo")
    private String motivo;
    
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    
    @JoinColumn(name = "id_inventario", referencedColumnName = "id_inventario")
    @ManyToOne(optional = false)
    private Inventario id_inventario;

    public DetallebajaArti() {
    }

	public Long getId_det_baja_art() {
		return id_det_baja_art;
	}

	public void setId_det_baja_art(Long id_det_baja_art) {
		this.id_det_baja_art = id_det_baja_art;
	}


	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Inventario getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(Inventario id_inventario) {
		this.id_inventario = id_inventario;
	}

    
}
