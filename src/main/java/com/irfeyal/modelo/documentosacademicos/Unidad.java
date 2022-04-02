package com.irfeyal.modelo.documentosacademicos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unidad")
public class Unidad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_unidad;
	
	@Column
	private String nombre_unidad;
	public Unidad() {
	}

	public Unidad(Long id_unidad, String nombre_unidad) {
		super();
		this.id_unidad = id_unidad;
		this.nombre_unidad = nombre_unidad;
	}

	public Long getIdUnidad() {
		return id_unidad;
	}

	public void setIdUnidad(Long id_unidad) {
		this.id_unidad = id_unidad;
	}

	public String getNombre_unidad() {
		return nombre_unidad;
	}

	public void setNombre_unidad(String nombre_unidad) {
		this.nombre_unidad = nombre_unidad;
	}

}