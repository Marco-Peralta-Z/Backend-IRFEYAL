package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="correo_electronico")

public class CorreoElectronico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_correo")
	private Long id_correo;
	@Column(name="correo")
	private String correo;

	@ManyToOne
	@JoinColumn(name="id_extension")
	private Extension extension;

	public CorreoElectronico() {
	}


	public Long getid_correo() {
		return id_correo;
	}


	public void setid_correo(Long id_correo) {
		this.id_correo = id_correo;
	}


	public String getCorreo() {
		return correo;
	}


	public Long getId_correo() {
		return id_correo;
	}


	public void setId_correo(Long id_correo) {
		this.id_correo = id_correo;
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