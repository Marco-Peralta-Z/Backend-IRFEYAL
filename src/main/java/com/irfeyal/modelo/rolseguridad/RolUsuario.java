package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "rol_usuario")
public class RolUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol_usuario")
	private Long id_rol_usuario;
	@Column(name = "estado")
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_modulo")
	private Modulo id_modulo;

	public RolUsuario() {
	
	}


	public Long getid_rol_usuario() {
		return this.id_rol_usuario;
	}

	public void setid_rol_usuario(Long id_rol_usuario) {
		this.id_rol_usuario = id_rol_usuario;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Modulo getId_modulo() {
		return this.id_modulo;
	}

	public void setId_modulo(Modulo id_modulo) {
		this.id_modulo = id_modulo;
	}

}