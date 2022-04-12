package com.irfeyal.modelo.secretaria;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "documento")

public class Documento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_documento;
	
	@Column
	private String tipo_documento;
	
	@Column
	private String descripcion;
	
	@Column
	private String ubicacion;
	
	
	public Documento() {
		
	}

	public Documento(Long id_documento, String tipo_documento, String descripcion, String ubicacion) {
		
		this.id_documento = id_documento;
		this.tipo_documento = tipo_documento;
		this.descripcion = descripcion;
		this.ubicacion = ubicacion;
	}

	public Long getId_documento() {
		return id_documento;
	}

	public void setId_documento(Long id_documento) {
		this.id_documento = id_documento;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
}
