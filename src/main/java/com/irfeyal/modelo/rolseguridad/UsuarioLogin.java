package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "usuarioLogin")
@NamedQuery(name="UsuarioLogin.findAll", query="SELECT u FROM UsuarioLogin u")
public class UsuarioLogin implements Serializable {
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
	
	@Column(name="id_rol_usuario")
	private Long id_rol_usuario;
	
	@Column(name="id_rol")
	private Long id_rol;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="id_modulo")
	private Long id_modulo;
	
	@Column(name="modulo")
	private String modulo;

	public UsuarioLogin() {
	}

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

	public Long getId_rol_usuario() {
		return id_rol_usuario;
	}

	public void setId_rol_usuario(Long id_rol_usuario) {
		this.id_rol_usuario = id_rol_usuario;
	}

	public Long getId_rol() {
		return id_rol;
	}

	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getId_modulo() {
		return id_modulo;
	}

	public void setId_modulo(Long id_modulo) {
		this.id_modulo = id_modulo;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


}