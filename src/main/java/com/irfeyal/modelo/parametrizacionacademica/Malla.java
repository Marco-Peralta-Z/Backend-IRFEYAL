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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "malla")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Malla implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_malla;

	@NotNull(message = "Debe ingresar un estado para la Malla")
	@Column(name = "estado")
	private Boolean estado;

	@NotBlank(message = "Debe ingresar una descripción para la Malla")
	@Column(name = "descripcion", length = 999)
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@PrePersist
	private void setDateFecha() {
		this.fecha_creacion = new Date();
	}

	// Relación Malla-Curso
	@ManyToMany
	@JoinTable(name = "malla_curso", joinColumns = { @JoinColumn(name = "id_malla") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso") })
	private List<Curso> listaCursos = new ArrayList<Curso>();

	// Relación Malla con Área
	@ManyToMany
	@JoinTable(name = "malla_asignatura", joinColumns = { @JoinColumn(name = "id_malla") }, inverseJoinColumns = {
			@JoinColumn(name = "id_asignatura") })
	private List<Asignatura> listaAsignaturas = new ArrayList<>();

	// Relación Malla con Modalidad
	@ManyToOne()
	@JoinColumn(name = "id_modalidad")
	private Modalidad id_modalidad;

	@ManyToMany
	@JoinTable(name = "malla_area", joinColumns = { @JoinColumn(name = "id_malla") }, inverseJoinColumns = {
			@JoinColumn(name = "id_area") })
	private List<Area> listarea = new ArrayList<>();

	public Malla(Long id_malla, Boolean estado, String descripcion, Date fecha_creacion, List<Curso> listaCursos,
			List<Asignatura> listaAsignaturas, Modalidad id_modalidad, List<Area> listarea) {
		this.id_malla = id_malla;
		this.estado = estado;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.listaCursos = listaCursos;
		this.listaAsignaturas = listaAsignaturas;
		this.id_modalidad = id_modalidad;
		this.listarea = listarea;
	}

	public List<Area> getListarea() {
		return listarea;
	}

	public void setListarea(List<Area> listarea) {
		this.listarea = listarea;
	}

	public Long getId_malla() {
		return id_malla;
	}

	public void setId_malla(Long id_malla) {
		this.id_malla = id_malla;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public List<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

	public Modalidad getId_modalidad() {
		return id_modalidad;
	}

	public void setId_modalidad(Modalidad id_modalidad) {
		this.id_modalidad = id_modalidad;
	}

	@Override
	public String toString() {
		return "Malla [descripcion=" + descripcion + ", estado=" + estado + ", fecha_creacion=" + fecha_creacion
				+ ", id_malla=" + id_malla + ", listaAsignaturas=" + listaAsignaturas + ", listaCursos=" + listaCursos
				+ ", id_modalidad=" + id_modalidad + ",listarea =" + listarea + "]";
	}

}
