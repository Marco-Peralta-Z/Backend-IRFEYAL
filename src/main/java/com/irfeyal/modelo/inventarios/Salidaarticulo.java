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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.irfeyal.modelo.rolseguridad.Empleado;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "salida_articulo")
public class Salidaarticulo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_salida_art")
	private Long id_salida_art;

	@Column(name = "fecha_salida")
	@Temporal(TemporalType.DATE)
	private Date fechaSalida;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "detallesalida")
	private String detallesalida;

	@JoinColumn(name = "id_inventario", referencedColumnName = "id_inventario", unique = true)
	@ManyToOne(optional = false)
	private Inventario inventario;
	
	@JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", unique = false)
	@OneToOne(optional = true)
	private Empleado empleado;

	public Salidaarticulo() {
	}

	public Long getId_salida_art() {
		return id_salida_art;
	}

	public void setId_salida_art(Long id_salida_art) {
		this.id_salida_art = id_salida_art;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDetallesalida() {
		return detallesalida;
	}

	public void setDetallesalida(String detallesalida) {
		this.detallesalida = detallesalida;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	

}
