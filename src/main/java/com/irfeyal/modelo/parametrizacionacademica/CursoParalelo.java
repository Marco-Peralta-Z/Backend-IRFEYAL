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

@Entity
@Table(name = "curso_paralelo")
public class CursoParalelo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_curso_paralelo;

	
	@ManyToOne
	@JoinColumn (name = "id_paralelo")
	private Paralelo id_paralelo;
	
	@ManyToOne
	@JoinColumn (name = "id_curso")
	private Curso id_curso;

	
	public CursoParalelo() {
		super();
	}

	public CursoParalelo(Long id_curso_paralelo, Paralelo id_paralelo, Curso id_curso) {
		super();
		this.id_curso_paralelo = id_curso_paralelo;
		this.id_paralelo = id_paralelo;
		this.id_curso = id_curso;
	}

	public Long getId_curso_paralelo() {
		return id_curso_paralelo;
	}

	public void setId_curso_paralelo(Long id_curso_paralelo) {
		this.id_curso_paralelo = id_curso_paralelo;
	}

	public Paralelo getId_paralelo() {
		return id_paralelo;
	}

	public void setId_paralelo(Paralelo id_paralelo) {
		this.id_paralelo = id_paralelo;
	}

	public Curso getId_curso() {
		return id_curso;
	}

	public void setId_curso(Curso id_curso) {
		this.id_curso = id_curso;
	}
	
	
	
}
