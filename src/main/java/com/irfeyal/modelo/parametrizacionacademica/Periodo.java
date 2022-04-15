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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//Modificado por: Josué Quichimbo. Fecha: 07/04/22. Hora: 16:41.

@Data
@Entity
@Table(name = "periodo")
public class Periodo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_periodo;

	@NotEmpty(message = "Debe ingresar las actividades para el Periodo")
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
	@JoinColumn(name = "id_malla")
	private Malla malla;

}
