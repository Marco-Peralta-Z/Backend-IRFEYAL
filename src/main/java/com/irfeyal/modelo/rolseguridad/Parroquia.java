package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;


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

	@ManyToOne()
	@JoinColumn(name="idCanton")
	private Canton canton;
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

	public Long getId_parroquia() {
		return id_parroquia;
	}

	public void setId_parroquia(Long id_parroquia) {
		this.id_parroquia = id_parroquia;
	}

	public Canton getCanton() {
		return canton;
	}

	public void setCanton(Canton canton) {
		this.canton = canton;
	}

	
}