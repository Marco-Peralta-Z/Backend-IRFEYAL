package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the correo_electronico database table.
 * 
 */
@Entity
@Table(name="correo_electronico")
@NamedQuery(name="CorreoElectronico.findAll", query="SELECT c FROM CorreoElectronico c")
public class CorreoElectronico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_correo")
	private Integer idCorreo;

	private String correo;

	//bi-directional many-to-one association to Empresa
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;

	//bi-directional many-to-one association to Extension
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_extension")
	private Extension extension;

	//bi-directional many-to-one association to Persona
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public CorreoElectronico() {
	}

	public Integer getIdCorreo() {
		return this.idCorreo;
	}

	public void setIdCorreo(Integer idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Extension getExtension() {
		return this.extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}