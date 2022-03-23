package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name="empresa")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_empresa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpresa;

	private String empresa;

	//bi-directional many-to-one association to CorreoElectronico
	@OneToMany()
	private List<CorreoElectronico> correoElectronicos;

	//bi-directional many-to-one association to Direccion
	@OneToMany()
	private List<Direccion> direccions;

	//bi-directional many-to-one association to Usuario
	@OneToMany()
	private List<Usuario> id_usuario;

	//bi-directional many-to-one association to Extension
	

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="empresa")
	private List<Telefono> telefonos;

	public Empresa() {
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public List<CorreoElectronico> getCorreoElectronicos() {
		return this.correoElectronicos;
	}

	public void setCorreoElectronicos(List<CorreoElectronico> correoElectronicos) {
		this.correoElectronicos = correoElectronicos;
	}

	public CorreoElectronico addCorreoElectronico(CorreoElectronico correoElectronico) {
		getCorreoElectronicos().add(correoElectronico);
		correoElectronico.setEmpresa(this);

		return correoElectronico;
	}

	public CorreoElectronico removeCorreoElectronico(CorreoElectronico correoElectronico) {
		getCorreoElectronicos().remove(correoElectronico);
		correoElectronico.setEmpresa(null);

		return correoElectronico;
	}

	public List<Direccion> getDireccions() {
		return this.direccions;
	}

	public void setDireccions(List<Direccion> direccions) {
		this.direccions = direccions;
	}

	public Direccion addDireccion(Direccion direccion) {
		getDireccions().add(direccion);
		direccion.setEmpresa(this);

		return direccion;
	}

	public Direccion removeDireccion(Direccion direccion) {
		getDireccions().remove(direccion);
		direccion.setEmpresa(null);

		return direccion;
	}


	public List<Usuario> getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(List<Usuario> id_usuario) {
		this.id_usuario = id_usuario;
	}

	public List<Telefono> getTelefonos() {
		return this.telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Telefono addTelefono(Telefono telefono) {
		getTelefonos().add(telefono);
		telefono.setEmpresa(this);

		return telefono;
	}

	public Telefono removeTelefono(Telefono telefono) {
		getTelefonos().remove(telefono);
		telefono.setEmpresa(null);

		return telefono;
	}

}