package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	@Column(name = "descripcion")
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "malla_asignatura", joinColumns = { @JoinColumn(name = "id_malla") }, inverseJoinColumns = {
			@JoinColumn(name = "id_asignatura") })
	private List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();

	@PrePersist
	private void setDateFecha() {
		this.fecha_creacion = new Date();
	}

	// Relación Malla-Curso
	@ManyToMany
	@JoinTable(name = "malla_curso", joinColumns = { @JoinColumn(name = "id_malla") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso") })
	private List<Curso> listaCursos = new ArrayList<Curso>();

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

	public List<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	@Override
	public String toString() {
		return "Malla [descripcion=" + descripcion + ", estado=" + estado + ", fecha_creacion=" + fecha_creacion
				+ ", id_malla=" + id_malla + ", listaAsignaturas=" + listaAsignaturas + ", listaCursos=" + listaCursos
				+ "]";
	}

}
