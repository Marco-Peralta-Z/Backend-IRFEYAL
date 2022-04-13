package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "extension")
@NamedQuery(name="Extension.findAll", query="SELECT e FROM Extension e")
public class Extension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_extension")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_extension;

	@Column(name="nombre_extension")
	private String nombre_extension;

	@OneToOne
	@JoinColumn(name = "id_direccion")
	private Direccion id_direccion;
	
	@ManyToOne()
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	public Extension() {
	}

	public Long getId_extension() {
		return id_extension;
	}

	public void setId_extension(Long id_extension) {
		this.id_extension = id_extension;
	}

	public String getnombre_extension() {
		return nombre_extension;
	}

	public void setnombre_extension(String nombre_extension) {
		this.nombre_extension = nombre_extension;
	}


	public Direccion getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(Direccion id_direccion) {
		this.id_direccion = id_direccion;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	
}