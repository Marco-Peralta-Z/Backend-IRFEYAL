package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the extension database table.
 * 
 */
@Entity
@Table(name="extension")
@NamedQuery(name="Extension.findAll", query="SELECT e FROM Extension e")
public class Extension implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_extension")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_extension;

	@Column(name="extension")
	private String extension;

	//bi-directional many-to-one association to CorreoElectronico
	@OneToMany()
	private List<CorreoElectronico> correoElectronicos;

	
	//bi-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name="id_direccion")
	private Direccion direccion;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="id_empresa")
	private Empresa id_empresa;
	//bi-directional many-to-one association to Empresa

	//bi-directional many-to-one association to Telefono
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


	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public List<CorreoElectronico> getCorreoElectronicos() {
		return this.correoElectronicos;
	}

	public void setCorreoElectronicos(List<CorreoElectronico> correoElectronicos) {
		this.correoElectronicos = correoElectronicos;
	}

	public CorreoElectronico addCorreoElectronico(CorreoElectronico correoElectronico) {
		getCorreoElectronicos().add(correoElectronico);
		correoElectronico.setExtension(this);

		return correoElectronico;
	}

	public CorreoElectronico removeCorreoElectronico(CorreoElectronico correoElectronico) {
		getCorreoElectronicos().remove(correoElectronico);
		correoElectronico.setExtension(null);

		return correoElectronico;
	}

	public Empresa getId_empresa() {
		return id_empresa;
	}


	public void setId_empresa(Empresa id_empresa) {
		this.id_empresa = id_empresa;
	}


	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public List<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Telefono addTelefono(Telefono telefono) {
		getTelefonos().add(telefono);
		telefono.setExtension(this);

		return telefono;
	}

	public Telefono removeTelefono(Telefono telefono) {
		getTelefonos().remove(telefono);
		telefono.setExtension(null);

		return telefono;
	}

}