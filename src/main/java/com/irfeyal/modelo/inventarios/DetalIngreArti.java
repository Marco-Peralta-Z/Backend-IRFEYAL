package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "detal_ingre_arti")
public class DetalIngreArti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_det_ingre_art")
    private Long id_det_ingre_art;
    
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    
    @Column(name = "cantidad")
    private Long cantidad;
    
    @Column(name = "observacion")
    private String observacion;
    
    @Column(name = "tipo_ingreso")
    private String tipoIngreso;
    
    @Basic(optional = false)
    @Column(name = "id_aprobacion")
    private int id_aprobacion;
    

    public DetalIngreArti() {
    }


	public Long getId_det_ingre_art() {
		return id_det_ingre_art;
	}


	public void setId_det_ingre_art(Long id_det_ingre_art) {
		this.id_det_ingre_art = id_det_ingre_art;
	}


	public Date getFechaingreso() {
		return fechaingreso;
	}


	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}


	public Long getCantidad() {
		return cantidad;
	}


	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getTipoIngreso() {
		return tipoIngreso;
	}


	public void setTipoIngreso(String tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}


	public int getId_aprobacion() {
		return id_aprobacion;
	}


	public void setId_aprobacion(int id_aprobacion) {
		this.id_aprobacion = id_aprobacion;
	}

}
