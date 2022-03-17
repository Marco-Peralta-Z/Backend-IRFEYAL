package com.example.demo.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_empresa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpresa;

	private String empresa;

	//bi-directional many-to-one association to CorreoElectronico
	@OneToMany()
	private List<CorreoElectronico> correoElectronicos;

	//bi-directional many-to-one association to Direccion
	@OneToMany()
	private List<Direccion> direccions;

	//bi-directional many-to-one association to Usuario
	@OneToMany()
	@Column(name="id_usuario")
	@JoinColumn(name="id_usuario")
	private List<Usuario> id_usuario;

	//bi-directional many-to-one association to Extension
	@OneToMany()
	@JoinColumn(name="id_extension")
	private List<Extension> extensions;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="empresa")
	private List<Telefono> telefonos;

	public Empresa() {
	}

	public Integer getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
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

	public List<Extension> getExtensions() {
		return this.extensions;
	}

	public void setExtensions(List<Extension> extensions) {
		this.extensions = extensions;
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