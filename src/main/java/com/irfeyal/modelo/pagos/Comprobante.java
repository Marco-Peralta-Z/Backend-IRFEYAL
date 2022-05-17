package com.irfeyal.modelo.pagos;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Entity
@Table(name = "comprobante")
@NamedQuery(name="Comprobante.findAll", query="SELECT c FROM Comprobante c")
public class Comprobante implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(columnDefinition = "serial")
	private Long id_comprobante;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha")
	private Calendar fecha;
	private String imagen;
	private float valor_total;
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_matricula")
	private Matricula id_matricula;

	@OneToOne
	@JoinColumn(name = "id_empleado")
	private Empleado id_empleado;

	@OneToOne
	@JoinColumn(name = "id_tipo_comprobante")
	private TipoComprobante id_tipo_comprobante;

	@OneToOne
	@JoinColumn(name = "id_tipo_pago")
	private TipoPago id_tipo_pago;

	public Comprobante() {

	}

	//public Comprobante(Long id_comprobante, Date fecha, String imagen, float valor_total, boolean estado,
		//	Matricula id_matricula, Empleado id_empleado, TipoComprobante id_tipo_comprobante,
		//	TipoPago id_tipo_pago) {
	//	this.id_comprobante = id_comprobante;
	//	this.fecha = fecha;
	//	this.imagen = imagen;
	//	this.valor_total = valor_total;
	//	this.estado = estado;
	//	this.id_matricula = id_matricula;
	//	this.id_empleado = id_empleado;
	//	this.id_tipo_comprobante = id_tipo_comprobante;
	//	this.id_tipo_pago = id_tipo_pago;
//	}

	public Long getId() {
		return id_comprobante;
	}

	public void setId(Long id_comprobante) {
		this.id_comprobante = id_comprobante;
	}

	

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public float getValor_total() {
		return valor_total;
	}

	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Matricula getIdMatricula() {
		return id_matricula;
	}

	public void setIdMatricula(Matricula id_matricula) {
		this.id_matricula = id_matricula;
	}

	public Empleado getEmpleado() {
		return id_empleado;
	}

	public void setEmpleado(Empleado id_empleado) {
		this.id_empleado = id_empleado;
	}

	public TipoComprobante getTipoComprobante() {
		return id_tipo_comprobante;
	}

	public void setTipoComprobante(TipoComprobante id_tipo_comprobante) {
		this.id_tipo_comprobante = id_tipo_comprobante;
	}

	public TipoPago getTipoPago() {
		return id_tipo_pago;
	}

	public void setTipoPago(TipoPago id_tipo_pago) {
		this.id_tipo_pago = id_tipo_pago;
	}

}