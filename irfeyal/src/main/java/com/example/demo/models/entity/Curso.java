package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_curso")
	private Integer idCurso;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="fec_creacion")
	private Timestamp fecCreacion;

	@Column(name="fecha_create")
	private Timestamp fechaCreate;

	@Column(name="tipo_curso")
	private String tipoCurso;

	public Curso() {
	}

	public Integer getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFecCreacion() {
		return this.fecCreacion;
	}

	public void setFecCreacion(Timestamp fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	public Timestamp getFechaCreate() {
		return this.fechaCreate;
	}

	public void setFechaCreate(Timestamp fechaCreate) {
		this.fechaCreate = fechaCreate;
	}

	public String getTipoCurso() {
		return this.tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

}