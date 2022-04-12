package com.irfeyal.modelo.pagos;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tipo_pago")

public class TipoPago implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_tipo_pago;
	
	@Column
	private String descripcion;
	
	public TipoPago() {
	}

	public TipoPago(Long id_tipo_pago, String descripcion) {
		this.id_tipo_pago = id_tipo_pago;
		this.descripcion = descripcion;
	}

	public Long getId_tipo_pago() {
		return id_tipo_pago;
	}

	public void setId_tipo_pago(Long id_tipo_pago) {
		this.id_tipo_pago = id_tipo_pago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}