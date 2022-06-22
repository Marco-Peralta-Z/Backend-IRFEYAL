package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "modalidad")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Modalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_modalidad;

	@NotBlank(message = "Debe ingresar una descripción para la Modalidad")
	@Column(name = "descripcion")
	private String descripcion;

	public Modalidad() {
		super();
	}
	
	//MODULO TURORIAS
	public Modalidad(Long id_modalidad) {
		super();
		this.id_modalidad = id_modalidad;
	}
	//----

	public Modalidad(Long id_modalidad, String descripcion) {
		this.id_modalidad = id_modalidad;
		this.descripcion = descripcion;
	}
	
	// agregado por el modulo de asistencia  necesario para  sus tablas

	public Modalidad(Long id_modalidad) {
		super();
		this.id_modalidad = id_modalidad;
	}

	


	public Modalidad() {
		super();
	}

	// fin agregado

	public Long getId_modalidad() {
		return id_modalidad;
	}

	public void setId_modalidad(Long id_modalidad) {
		this.id_modalidad = id_modalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Modalidad [descripcion=" + descripcion + ", id_modalidad=" + id_modalidad + "]";
	}

}
