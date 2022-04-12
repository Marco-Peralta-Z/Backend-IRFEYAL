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

import lombok.Data;

//Modificado por: Josué Quichimbo. Fecha: 07/04/22. Hora: 16:37.

@Data
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

}
