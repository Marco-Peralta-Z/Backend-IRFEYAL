package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

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
	private String name_extension;

	//bi-directional many-to-one association to CorreoElectronico
	@JsonIgnore
	@OneToMany()
	private List<CorreoElectronico> correoElectronicos;

	
	@OneToOne()
	@JoinColumn(name = "id_direccion")
	private Direccion id_direccion;
	//bi-directional many-to-one association to Empresa
	@JsonIgnore
	
	@ManyToOne()
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	//bi-directional many-to-one association to Telefono
	@JsonIgnore
	@OneToMany()
	private List<Telefono> telefonos;

	public Extension() {
	}

	public Long getId_extension() {
		return id_extension;
	}

	public void setId_extension(Long id_extension) {
		this.id_extension = id_extension;
	}

	public String getName_extension() {
		return name_extension;
	}

	public void setName_extension(String name_extension) {
		this.name_extension = name_extension;
	}

	public List<CorreoElectronico> getCorreoElectronicos() {
		return correoElectronicos;
	}

	public void setCorreoElectronicos(List<CorreoElectronico> correoElectronicos) {
		this.correoElectronicos = correoElectronicos;
	}

	public Direccion getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(Direccion id_direccion) {
		this.id_direccion = id_direccion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}