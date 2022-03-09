package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the paralelo database table.
 * 
 */
@Entity
@NamedQuery(name="Paralelo.findAll", query="SELECT p FROM Paralelo p")
public class Paralelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_paralelo")
	private Integer idParalelo;

	private String descripcion;

	@Column(name="fec_creacion")
	private Timestamp fecCreacion;



	public Paralelo() {
	}

	public Integer getIdParalelo() {
		return this.idParalelo;
	}

	public void setIdParalelo(Integer idParalelo) {
		this.idParalelo = idParalelo;
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

	

}