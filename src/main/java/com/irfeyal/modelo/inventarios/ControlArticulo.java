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
@Table(name = "control_articulo")
public class ControlArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_control_articulo")
    private Long id_control_articulo;
    
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    
    @Column(name = "cantidad")
    private Long cantidad;
    
    @Column(name = "observacion")
    private String observacion;
    


    public ControlArticulo() {
    }


    

	public Long getId_control_articulo() {
		return id_control_articulo;
	}




	public void setId_control_articulo(Long id_control_articulo) {
		this.id_control_articulo = id_control_articulo;
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





}
