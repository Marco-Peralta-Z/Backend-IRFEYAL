package com.example.demo.models.entity;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;


/**
 * The persistent class for the matriculas database table.
 * 
 */
@Entity
@Table(name="matriculas")
@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_matricula")
	private Long idMatricula;

	@Column(name="fecha_matricula")
	private Timestamp fechaMatricula;

	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_periodo")
	private Periodo id_periodo;

	//bi-directional many-to-one association to Curso
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_curso")
	private Curso curso;

	//bi-directional many-to-one association to Modalidad
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_modalidad")
	private Modalidad modalidad;

	//bi-directional many-to-one association to Usuario
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Paralelo
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_paralelo")
	private Paralelo id_paralelo;

	//bi-directional one-to-one association to Estudiante
	/*@OneToOne(fetch=FetchType.LAZY)
	@Column(name="id_estudiante")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Estudiante estudiante;
*/
	
//	 referencedColumnName = "id_estudiante", insertable = false, updatable = false
	
	@OneToOne()
	@JoinColumn(name = "id_estudiante")
	private Estudiante estudiante;

	
	
	public Matricula() {
	}
	
	public Long getIdMatricula() {
		return this.idMatricula;
	}

	public void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Timestamp getFechaMatricula() {
		return this.fechaMatricula;
	}

	public void setFechaMatricula(Timestamp fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	
	public Periodo getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(Periodo id_periodo) {
		this.id_periodo = id_periodo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Paralelo getId_paralelo() {
		return id_paralelo;
	}

	public void setId_paralelo(Paralelo id_paralelo) {
		this.id_paralelo = id_paralelo;
	}

	public Estudiante getEstudiante() {
		return this.estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}