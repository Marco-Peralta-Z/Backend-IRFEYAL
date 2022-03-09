package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



/**
 * The persistent class for the modalidad database table.
 * 
 */
@Entity
@NamedQuery(name="Modalidad.findAll", query="SELECT m FROM Modalidad m")
public class Modalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_modalidad")
	private Integer idModalidad;

	private String descripcion;

	@Column(name="hora_fin")
	private Timestamp horaFin;

	@Column(name="hora_inicio")
	private Timestamp horaInicio;


	public Modalidad() {
	}

	public Integer getIdModalidad() {
		return this.idModalidad;
	}

	public void setIdModalidad(Integer idModalidad) {
		this.idModalidad = idModalidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Timestamp horaFin) {
		this.horaFin = horaFin;
	}

	public Timestamp getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Timestamp horaInicio) {
		this.horaInicio = horaInicio;
	}


}