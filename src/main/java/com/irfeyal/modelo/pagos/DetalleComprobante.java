package com.irfeyal.modelo.pagos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_comprobante")

public class DetalleComprobante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_detalle_comprobante;
	
	private float valor;
	private String detalle;
	
	@OneToOne
	@JoinColumn(name = "id_comprobante")
	private Comprobante id_comprobante;

	public DetalleComprobante() {
		
	}

	public DetalleComprobante(Long id_detalle_comprobante, float valor, String detalle, Comprobante id_comprobante) {
		this.id_detalle_comprobante = id_detalle_comprobante;
		this.valor = valor;
		this.detalle = detalle;
		this.id_comprobante = id_comprobante;
	}

	public Long getIdDetalleComprobante() {
		return id_detalle_comprobante;
	}

	public void setIdDetalleComprobante(Long id_detalle_comprobante) {
		this.id_detalle_comprobante = id_detalle_comprobante;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Comprobante getIdComprobante() {
		return id_comprobante;
	}

	public void setIdComprobante(Comprobante id_comprobante) {
		this.id_comprobante = id_comprobante;
	}
	
}