package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name = "provincia")
@NamedQuery(name="Provincia.findAll", query="SELECT p FROM Provincia p")
public class Provincia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_provincia")
	private Long idProvincia;

	private String provincia;

	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pais;

	public Provincia() {
	}

	public Long getIdProvincia() {
		return this.idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	

}