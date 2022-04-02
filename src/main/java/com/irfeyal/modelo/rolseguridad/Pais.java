package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="pais")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pais")
	private Long id_pais;

	@Column(name="pais")
	private String pais;

	

	public Pais() {
	}

	public Long getid_pais() {
		return this.id_pais;
	}

	public void setid_pais(Long id_pais) {
		this.id_pais = id_pais;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	
	

}