package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "genero")
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_genero")
	private Long id_genero;

	private String genero;

	//bi-directional many-to-one association to Persona
	@JsonIgnore
	@OneToOne()
	private Persona personas;

	public Genero() {
	}

	public Long getid_genero() {
		return this.id_genero;
	}

	public void setid_genero(Long id_genero) {
		this.id_genero = id_genero;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


}