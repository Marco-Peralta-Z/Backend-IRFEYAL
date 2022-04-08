package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.irfeyal.modelo.rolseguridad.Empleado;

import lombok.Data;

//Modificado por: Josué Quichimbo. Fecha: 07/04/22. Hora: 16:35

@Data
@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_curso;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "tipo_curso")
	private String tipo_curso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Calendar fecha_creacion;

	// Relación Malla-Curso, bidireccional
	@ManyToMany(mappedBy = "listaCursos")
	private List<Malla> listaMallas = new ArrayList<Malla>();
	
	//Relación Modalidad-Curso, bidireccional
	@ManyToMany(mappedBy = "listaCursos")
	private List<Modalidad> listaModalidad = new ArrayList<Modalidad>();
	
	//Relación Curso-Paralelo, bidireccional
	@ManyToMany(mappedBy = "listaCursos")
	private List<Paralelo> listaParalelo = new ArrayList<Paralelo>();
	
	//Relación Curso-Horario, bidireccional
	@ManyToMany(mappedBy = "listaCursos")
	private List<Horario> listaHorario = new ArrayList<Horario>();
	
	@ManyToOne
	@JoinColumn(name = "empleado", unique = true)
	private Empleado empleado;

}
