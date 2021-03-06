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

import com.irfeyal.modelo.rolseguridad.Empleado;

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
    private int cantidad;
    
    @Column(name = "observacion")
    private String observacion;
    
    @JoinColumn(name = "id_administrador", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado administrador;


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
	
	


	public int getCantidad() {
		return cantidad;
	}




	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}




	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}




	public Empleado getAdministrador() {
		return administrador;
	}




	public void setAdministrador(Empleado administrador) {
		this.administrador = administrador;
	}





}
