package com.irfeyal.modelo.matricula;

import java.io.Serializable;
import javax.persistence.*;

import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.rolseguridad.Usuario;

import java.sql.Timestamp;

@Entity
@Table(name="matriculas")
@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_matricula")
	private Long id_matricula;

	@Column(name="fecha_matricula")
	private Timestamp fechaMatricula;
	
	@Column(name="modalidad")
	private String modalidad_estudio;

	@OneToOne()
	@JoinColumn(name = "id_periodo")
	private Periodo id_periodo;

	@ManyToOne()
	@JoinColumn(name="id_curso")
	private Curso curso;

	@ManyToOne()
	@JoinColumn(name="id_modalidad")
	private Modalidad modalidad;

	@ManyToOne()
	@JoinColumn(name="id_usuario")
	private Usuario usuario;


	@OneToOne()
	@JoinColumn(name="id_paralelo")
	private Paralelo id_paralelo;
	
	@OneToOne()
	@JoinColumn(name = "id_estudiante")
	private Estudiante estudiante;

	public Matricula() {
	}
	
	public Matricula(Long id_matricula, Timestamp fechaMatricula, String modalidad_estudio, Periodo id_periodo,
			Curso curso, Modalidad modalidad, Usuario usuario, Paralelo id_paralelo, Estudiante estudiante) {
		super();
		this.id_matricula = id_matricula;
		this.fechaMatricula = fechaMatricula;
		this.modalidad_estudio = modalidad_estudio;
		this.id_periodo = id_periodo;
		this.curso = curso;
		this.modalidad = modalidad;
		this.usuario = usuario;
		this.id_paralelo = id_paralelo;
		this.estudiante = estudiante;
	}


	public Matricula(Long id_matricula) {
		super();
		this.id_matricula = id_matricula;
	}

	public Long getid_matricula() {
		return this.id_matricula;
	}

	public void setid_matricula(Long id_matricula) {
		this.id_matricula = id_matricula;
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