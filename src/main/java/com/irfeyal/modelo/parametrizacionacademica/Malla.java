package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

//Modificado por: Josué Quichimbo. Fecha: 07/04/22. Hora: 16:39

@Data
@Entity
@Table(name = "malla")
public class Malla implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_malla;

	@Column(name = "estado")
	private Boolean estado;

	@Column(name = "descripcion")
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Calendar fecha_creacion;

	//Data binding, tabla Curso
	@ManyToMany
	@JoinTable(
			name = "malla_curso",
			joinColumns = { @JoinColumn(name = "id_malla") },
			inverseJoinColumns = { @JoinColumn(name = "id_curso") })
	private List<Curso> listaCursos;

}
