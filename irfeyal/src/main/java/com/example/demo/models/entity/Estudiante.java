package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the estudiantes database table.
 * 
 */
@Entity
@Table(name="estudiantes")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_estudiante")
	private Long idEstudiante;

	@Column(name="estado_estudiante")
	private Boolean estadoEstudiante;

	//bi-directional many-to-one association to Extension

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_extension")
	private Extension id_extension;

	//bi-directional one-to-one association to Persona
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name="id_persona")
	private Persona id_persona;

	//bi-directional one-to-one association to Matricula


	public Estudiante() {
	}

	public Long getIdEstudiante() {
		return this.idEstudiante;
	}

	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public Boolean getEstadoEstudiante() {
		return this.estadoEstudiante;
	}

	public void setEstadoEstudiante(Boolean estadoEstudiante) {
		this.estadoEstudiante = estadoEstudiante;
	}

	public Extension getId_extension() {
		return id_extension;
	}

	public void setId_extension(Extension id_extension) {
		this.id_extension = id_extension;
	}

	public Persona getId_persona() {
		return id_persona;
	}

	public void setId_persona(Persona id_persona) {
		this.id_persona = id_persona;
	}
	
	
}