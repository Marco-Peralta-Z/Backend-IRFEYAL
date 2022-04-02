package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "canton")
public class Canton implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_canton")
	private Long idCanton;

	private String canton;

	//bi-directional many-to-one association to Direccion
	@JsonIgnore
	@OneToMany(mappedBy="canton")
	private List<Direccion> direccions;

	public Canton() {
	}

	public Long getIdCanton() {
		return this.idCanton;
	}

	public void setIdCanton(Long idCanton) {
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