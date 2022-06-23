package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id_usuario;
	
	@Column(name="contrasenia")
	private String contrasenia;

	@Column(name="est_usuario")
	private Boolean estUsuario;

	@Column(name="usuario")
	private String usuario;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;
	
	/*
	 * Bidirectional relation
	 * */
	
	@JsonIgnoreProperties( value = {"usuario", "hibernateLazyInitializer", "handler"}, allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<RolUsuario> roles;
	
	public Usuario() {
	}
	
	//MODULOTUTORIAS
	public Usuario(Long id_usuario) {
		super();
		this.id_usuario = id_usuario;
	}
	//-----

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Boolean getEstUsuario() {
		return estUsuario;
	}

	public void setEstUsuario(Boolean estUsuario) {
		this.estUsuario = estUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<RolUsuario> getRoles() {
		return roles;
	}

	public void setRoles(List<RolUsuario> roles) {
		this.roles = roles;
	}
	
}