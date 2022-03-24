package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the canton database table.
 * 
 */
@Entity
@Table(name="canton")
@NamedQuery(name="Canton.findAll", query="SELECT c FROM Canton c")
public class Canton implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_canton")
	private Integer idCanton;

	private String canton;

	//bi-directional many-to-one association to Direccion
	@JsonIgnore
	@OneToMany(mappedBy="canton")
	private List<Direccion> direccions;

	public Canton() {
	}

	public Integer getIdCanton() {
		return this.idCanton;
	}

	public void setIdCanton(Integer idCanton) {
		this.idCanton = idCanton;
	}

	public String getCanton() {
		return this.canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setCanton(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setCanton(null);

		return direccion;
	}

}