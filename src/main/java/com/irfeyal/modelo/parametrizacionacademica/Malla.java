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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "malla")
public class Malla implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_malla;

	@NotNull(message = "Debe ingresar un estado para la Malla")
	@Column(name = "estado")
	private Boolean estado;
	
	@NotEmpty(message = "Debe ingresar una descripción para la Malla")
	@Column(name = "descripcion")
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@PrePersist
	private void setDateFecha(){
		this.fecha_creacion = new Date();
	}

	// Relación Malla-Curso
	@ManyToMany
	@JoinTable(name = "malla_curso", joinColumns = { @JoinColumn(name = "id_malla") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso") })
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<Curso> listaCursos = new ArrayList<Curso>();

}
