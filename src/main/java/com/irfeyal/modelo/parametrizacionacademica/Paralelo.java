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
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "paralelo")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Paralelo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_paralelo;

	@NotBlank(message = "Debe ingresar una descripción para el Paralelo")
	@Column(name = "descripcion")
	private String descripcion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@PrePersist
	private void setFechaCreacion() {
		this.fecha_creacion = new Date();
	}

	// Relacion curso_paralelo
	@ManyToMany
	@JoinTable(name = "curso_paralelo", joinColumns = { @JoinColumn(name = "id_paralelo") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso") })
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Curso> listaCursos = new ArrayList<Curso>();

	
	public Paralelo() {
		super();
	}
	

	public Paralelo(Long id_paralelo) {
		super();
		this.id_paralelo = id_paralelo;
	}


	public Long getId_paralelo() {
		return id_paralelo;
	}

	public void setId_paralelo(Long id_paralelo) {
		this.id_paralelo = id_paralelo;
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

	@Override
	public String toString() {
		return "Paralelo [descripcion=" + descripcion + ", fecha_creacion=" + fecha_creacion + ", id_paralelo="
				+ id_paralelo + ", listaCursos=" + listaCursos + "]";
	}

}
