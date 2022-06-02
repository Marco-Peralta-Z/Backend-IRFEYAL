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
@Table(name = "recepcion_articulo")
public class RecepcionArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recepcion_art")
    private Long id_recepcion_art;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "detallerecep")
    private String detallerecep;
    @JoinColumn(name = "id_control_articulo", referencedColumnName = "id_control_articulo")
    @ManyToOne(optional = false)
    private ControlArticulo controlArticulo;

    public RecepcionArticulo() {
    }

	public Long getId_recepcion_art() {
		return id_recepcion_art;
	}

	public void setId_recepcion_art(Long id_recepcion_art) {
		this.id_recepcion_art = id_recepcion_art;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDetallerecep() {
		return detallerecep;
	}

	public void setDetallerecep(String detallerecep) {
		this.detallerecep = detallerecep;
	}

	public ControlArticulo getControlArticulo() {
		return controlArticulo;
	}

	public void setControlArticulo(ControlArticulo controlArticulo) {
		this.controlArticulo = controlArticulo;
	}


    
    
}
