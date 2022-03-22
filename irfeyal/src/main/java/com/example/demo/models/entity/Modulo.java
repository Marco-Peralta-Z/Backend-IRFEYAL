package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Modulo.findAll", query="SELECT m FROM Modulo m")


public class Modulo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_modulo")
	private Integer idModulo;

	private String modulo;

	//bi-directional many-to-one association to Rol Usuario
	@OneToMany(mappedBy="modulo")
	private List<RolUsuario> rolusuario;
	
	public Modulo () {
		
		
	}
	public Integer getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public List<RolUsuario> getRolUsuario() {
		return this.rolusuario;
	}

	public void setRolUsuario(List<RolUsuario> rolusuario) {
		this.rolusuario = rolusuario;
	}


	
	
	
}
