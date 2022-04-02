package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "telefono")
@NamedQuery(name="Telefono.findAll", query="SELECT t FROM Telefono t")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_telefono")
	private Long id_telefono;

	@Column(name="num_celular")
	private String numCelular;

	private String telefono;

	//bi-directional many-to-one association to Extension
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_extension")
	private Extension extension;

	public Telefono() {
	}

	public Long getid_telefono() {
		return id_telefono;
	}

	public void setid_telefono(Long id_telefono) {
		this.id_telefono = id_telefono;
	}

	public String getNumCelular() {
		return numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}