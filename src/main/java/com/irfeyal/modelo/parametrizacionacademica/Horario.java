package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irfeyal.modelo.rolseguridad.Empleado;

import lombok.Data;

@Data
@Entity
@Table(name = "horario")
public class Horario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_horario;

	@NotEmpty(message = "Debe ingresar un tiempo de inicio")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "tiempo_inicio")
	private Date tiempo_inicio;

	@NotEmpty(message = "Debe ingresar un tiempo de fin")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "tiempo_fin")
	private Date tiempo_fin;

	@NotEmpty(message = "Debe ingresar un dia para el curso")
	@Column(name = "dia")
	private int dia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@PrePersist
	private void setDateFecha(){
		this.fecha_creacion = new Date();
	}

	// Relación Curso-Horario
	@ManyToMany
	@JoinTable(name = "curso_horario", joinColumns = { @JoinColumn(name = "id_horario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso") })
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Curso> listaCursos = new ArrayList<>();

	// Relación horario_empleado
	@ManyToMany
	@JoinTable(name = "horario_empleado", joinColumns = { @JoinColumn(name = "id_horario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_empleado") })
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Empleado> listaEmpleados = new ArrayList<>();

}
