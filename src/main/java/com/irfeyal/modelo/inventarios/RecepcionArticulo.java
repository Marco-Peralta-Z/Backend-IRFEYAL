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
@NamedQueries({
    @NamedQuery(name = "RecepcionArticulo.findAll", query = "SELECT r FROM RecepcionArticulo r"),
    @NamedQuery(name = "RecepcionArticulo.findByid_recepcion_art", query = "SELECT r FROM RecepcionArticulo r WHERE r.id_recepcion_art = :id_recepcion_art"),
    @NamedQuery(name = "RecepcionArticulo.findByFecha", query = "SELECT r FROM RecepcionArticulo r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "RecepcionArticulo.findByCodigo", query = "SELECT r FROM RecepcionArticulo r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "RecepcionArticulo.findByDetallerecep", query = "SELECT r FROM RecepcionArticulo r WHERE r.detallerecep = :detallerecep")})
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
    @JoinColumn(name = "id_det_ingre_art", referencedColumnName = "id_det_ingre_art")
    @ManyToOne(optional = false)
    private DetalIngreArti id_det_ingre_art;

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

	public DetalIngreArti getId_det_ingre_art() {
		return id_det_ingre_art;
	}

	public void setId_det_ingre_art(DetalIngreArti id_det_ingre_art) {
		this.id_det_ingre_art = id_det_ingre_art;
	}

    
    
}
