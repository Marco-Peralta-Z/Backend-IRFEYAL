package com.irfeyal.modelo.rolseguridad;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="rol_usuario")
public class RolUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rol_usuario")
	private Long id_rol_usuario;

	private Boolean estado;

	
//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;



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

	

}