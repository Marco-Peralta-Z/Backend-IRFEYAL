package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Integer idRol;

	private String descripcion;

	//bi-directional many-to-one association to RolUsuario
	@OneToMany(mappedBy="rol")
	private List<RolUsuario> rolUsuarios;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_modulo")
	private Modulo modulo;

	public Rol() {
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public Modulo getModulo() {
		return modulo;
	}


	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<RolUsuario> getRolUsuarios() {
		return this.rolUsuarios;
	}


	public void setRolUsuarios(List<RolUsuario> rolUsuarios) {
		this.rolUsuarios = rolUsuarios;
	}

	public RolUsuario addRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().add(rolUsuario);
		rolUsuario.setRol(this);

		return rolUsuario;
	}

	public RolUsuario removeRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().remove(rolUsuario);
		rolUsuario.setRol(null);

		return rolUsuario;
	}

}