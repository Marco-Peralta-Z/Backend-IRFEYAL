package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "parroquia")
@NamedQuery(name="Parroquia.findAll", query="SELECT p FROM Parroquia p")
public class Parroquia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_parroquia")
	private Long id_parroquia;

	private String parroquia;

	//bi-directional many-to-one association to Direccion
	@JsonIgnore
	@OneToMany(mappedBy="parroquia")
	private List<Direccion> direccions;

	public Parroquia() {
	}

	public Long getid_parroquia() {
		return this.id_parroquia;
	}

	public void setid_parroquia(Long id_parroquia) {
		this.id_parroquia = id_parroquia;
	}

	public String getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setParroquia(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setParroquia(null);

		return direccion;
	}

}