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


	//bi-directional many-to-one association to Extension
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_extension")
	private Extension extension;


	public CorreoElectronico() {
	}


	public Integer getIdCorreo() {
		return idCorreo;
	}


	public void setIdCorreo(Integer idCorreo) {
		this.idCorreo = idCorreo;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
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