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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//Modificado por: Josué Quichimbo. Fecha: 07/04/22. Hora: 16:40.

@Data
@Entity
@Table(name = "paralelo")
public class Paralelo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_paralelo;

	@Column(name = "descripcion")
	private String descripcion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_creacion")
	private Date fecha_creacion_paralelo;
	
	@PrePersist
	private void setFechaCreacion() {
		this.fecha_creacion_paralelo = new Date();
	}
	
	//Relacion Curso-Paralelo, bidireccional, propietario Paralelo
	@ManyToMany
	@JoinTable(
			name = "curso_paralelo",
			joinColumns = { @JoinColumn(name = "id_paralelo") },
			inverseJoinColumns = { @JoinColumn(name = "id_curso") })
	private List<Curso> listaCursos = new ArrayList<Curso>();

}
