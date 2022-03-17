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
	private Integer idEmpresa;

	private String empresa;

	//bi-directional many-to-one association to CorreoElectronico
	@OneToMany(mappedBy="empresa")
	private List<CorreoElectronico> correoElectronicos;

	//bi-directional many-to-one association to Direccion
	@OneToMany(mappedBy="empresa")
	private List<Direccion> direccions;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Extension
	@OneToMany(mappedBy="empresa")
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Extension> getExtensions() {
		return this.extensions;
	}

	public void setExtensions(List<Extension> extensions) {
		this.extensions = extensions;
	}

	public Extension addExtension(Extension extension) {
		getExtensions().add(extension);
		extension.setEmpresa(this);

		return extension;
	}

	public Extension removeExtension(Extension extension) {
		getExtensions().remove(extension);
		extension.setEmpresa(null);

		return extension;
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