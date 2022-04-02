package com.irfeyal.modelo.asistencia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.irfeyal.modelo.matricula.Estudiante;

@Entity
@Table(name = "asistencia")
//pueba
public class Asistencia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_asistencia;

	@Column(name = "estado_asistencia")
	private String estadoAsistencia;

	@Column(name = "num_faltas")
	private int numFaltas;
	
	@JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
	@ManyToOne(fetch = FetchType.LAZY)
	private Clase idClase;
	
	@JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
	@ManyToOne(fetch = FetchType.LAZY)
	private Estudiante id_estudiante;

	public Asistencia(Long id_asistencia) {
		this.id_asistencia = id_asistencia;
	}

	public Asistencia(Long id_asistencia, String estadoAsistencia, int numFaltas, Clase idClase, Estudiante id_estudiante) {
		this.id_asistencia = id_asistencia;
		this.estadoAsistencia = estadoAsistencia;
		this.numFaltas = numFaltas;
		this.idClase = idClase;
		this.id_estudiante = id_estudiante;
	}

	public Long getid_asistencia() {
		return id_asistencia;
	}

	public void setid_asistencia(Long id_asistencia) {
		this.id_asistencia = id_asistencia;
	}

	public int getNumFaltas() {
		return numFaltas;
	}

	public void setNumFaltas(int numFaltas) {
		this.numFaltas = numFaltas;
	}

	public Clase getIdClase() {
		return idClase;
	}

	public void setIdClase(Clase idClase) {
		this.idClase = idClase;
	}

	public Estudiante getid_estudiante() {
		return id_estudiante;
	}

	public void setid_estudiante(Estudiante id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
}