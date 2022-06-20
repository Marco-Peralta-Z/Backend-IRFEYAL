package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Entity
@Table(name = "tutor")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Tutor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_tutor;

	@ManyToOne()
	@JoinColumn(name = "id_paralelo")
	private Paralelo id_paralelo;

	@ManyToOne()
	@JoinColumn(name = "id_empleado")
	private Empleado id_empleado;

	@ManyToOne()
	@JoinColumn(name = "id_curso")
	private Curso id_curso;

	public Tutor() {
		super();
	}

	public Tutor(Long id_tutor, Paralelo id_paralelo, Empleado id_empleado, Curso id_curso) {
		this.id_tutor = id_tutor;
		this.id_paralelo = id_paralelo;
		this.id_empleado = id_empleado;
		this.id_curso = id_curso;
	}

	public Long getId_tutor() {
		return id_tutor;
	}

	public void setId_tutor(Long id_tutor) {
		this.id_tutor = id_tutor;
	}

	public Paralelo getId_paralelo() {
		return id_paralelo;
	}

	public void setId_paralelo(Paralelo id_paralelo) {
		this.id_paralelo = id_paralelo;
	}

	public Empleado getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Empleado id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Curso getId_curso() {
		return id_curso;
	}

	public void setId_curso(Curso id_curso) {
		this.id_curso = id_curso;
	}

	@Override
	public String toString() {
		return "Tutor [id_empleado=" + id_empleado + ", id_curso=" + id_curso + ", id_paralelo=" + id_paralelo
				+ ", id_tutor=" + id_tutor + "]";
	}

}
