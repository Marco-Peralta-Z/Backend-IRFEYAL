package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "periodo")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Periodo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_periodo;

	@NotBlank(message = "Debe ingresar las actividades para el Periodo")
	@Column(name = "actividades")
	private String actividades;

	@NotNull(message = "Debe ingresar una fecha para las actividades del Periodo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_actividad")
	private Date fecha_actividad;

	@NotNull(message = "Debe ingresar una fecha final para el Periodo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;

	@NotNull(message = "Debe ingresar una fecha final para el Periodo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_fin")
	private Date fecha_fin;

	@NotNull(message = "Debe ingresar costo mensualidad del Periodo")
	@Column(name = "costo_mensualidad")
	private Double costo_mensualidad;

	@NotNull(message = "Debe ingresar el costo de la matrícula para el Periodo")
	@Column(name = "costo_matricula")
	private Double costo_matricula;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@PrePersist
	private void setDateFecha() {
		this.fecha_creacion = new Date();
	}

	// Relación Periodo-Malla
	@ManyToOne
	@JoinColumn(name = "id_malla", nullable = true)
	private Malla malla;

	
	
	
	public Periodo() {
		super();
	}



	public Periodo(Long id_periodo) {
		super();
		this.id_periodo = id_periodo;
	}
	
	

	public Long getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(Long id_periodo) {
		this.id_periodo = id_periodo;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public Date getFecha_actividad() {
		return fecha_actividad;
	}

	public void setFecha_actividad(Date fecha_actividad) {
		this.fecha_actividad = fecha_actividad;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Double getCosto_mensualidad() {
		return costo_mensualidad;
	}

	public void setCosto_mensualidad(Double costo_mensualidad) {
		this.costo_mensualidad = costo_mensualidad;
	}

	public Double getCosto_matricula() {
		return costo_matricula;
	}

	public void setCosto_matricula(Double costo_matricula) {
		this.costo_matricula = costo_matricula;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Malla getMalla() {
		return malla;
	}

	public void setMalla(Malla malla) {
		this.malla = malla;
	}

	@Override
	public String toString() {
		return "Periodo [actividades=" + actividades + ", costo_matricula=" + costo_matricula + ", costo_mensualidad="
				+ costo_mensualidad + ", fecha_actividad=" + fecha_actividad + ", fecha_creacion=" + fecha_creacion
				+ ", fecha_fin=" + fecha_fin + ", fecha_inicio=" + fecha_inicio + ", id_periodo=" + id_periodo
				+ ", malla=" + malla + "]";
	}

}
