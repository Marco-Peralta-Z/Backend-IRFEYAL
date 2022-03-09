package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the periodo database table.
 * 
 */
@Entity
@NamedQuery(name="Periodo.findAll", query="SELECT p FROM Periodo p")
public class Periodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_periodo")
	private Integer idPeriodo;

	private String actividades;

	@Column(name="costo_matricula")
	private BigDecimal costoMatricula;

	@Column(name="costo_mensualidad")
	private BigDecimal costoMensualidad;

	@Column(name="fecha_activiti")
	private Timestamp fechaActiviti;

	@Column(name="fecha_creacion")
	private Timestamp fechaCreacion;

	@Column(name="fecha_fin")
	private Timestamp fechaFin;

	@Column(name="fecha_inicio")
	private Timestamp fechaInicio;

	//bi-directional many-to-one association to Malla

	public Periodo() {
	}

	public Integer getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getActividades() {
		return this.actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public BigDecimal getCostoMatricula() {
		return this.costoMatricula;
	}

	public void setCostoMatricula(BigDecimal costoMatricula) {
		this.costoMatricula = costoMatricula;
	}

	public BigDecimal getCostoMensualidad() {
		return this.costoMensualidad;
	}

	public void setCostoMensualidad(BigDecimal costoMensualidad) {
		this.costoMensualidad = costoMensualidad;
	}

	public Timestamp getFechaActiviti() {
		return this.fechaActiviti;
	}

	public void setFechaActiviti(Timestamp fechaActiviti) {
		this.fechaActiviti = fechaActiviti;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Timestamp getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}