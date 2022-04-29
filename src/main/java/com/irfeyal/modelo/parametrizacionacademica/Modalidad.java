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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "modalidad")
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Modalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_modalidad;

	@NotBlank(message = "Debe ingresar una descripción para la Modalidad")
	@Column(name = "descripcion")
	private String descripcion;

	@NotNull(message = "Debe ingresar una fecha y hora de inicio para la Modalidad")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "hora_inicio")
	private Date hora_inicio;

	@NotNull(message = "Debe ingresar una fecha y hora de fin para la Modalidad")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "hora_fin")
	private Date hora_fin;

	// Relación modalidad_curso
	@ManyToMany
	@JoinTable(name = "modalidad_curso", joinColumns = { @JoinColumn(name = "id_modalidad") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso") })
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Curso> listaCursos = new ArrayList<Curso>();

	
	
	
	public Modalidad() {
		super();
	}

	public Modalidad(Long id_modalidad) {
		super();
		this.id_modalidad = id_modalidad;
	}

	
	
	
	
	
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

	public Date getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Date getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Date hora_fin) {
		this.hora_fin = hora_fin;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	@Override
	public String toString() {
		return "Modalidad [descripcion=" + descripcion + ", hora_fin=" + hora_fin + ", hora_inicio=" + hora_inicio
				+ ", id_modalidad=" + id_modalidad + ", listaCursos=" + listaCursos + "]";
	}

}
