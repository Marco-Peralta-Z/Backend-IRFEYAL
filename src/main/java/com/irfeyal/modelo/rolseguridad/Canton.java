package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "canton")
public class Canton implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_canton")
	private Long idCanton;

	private String canton;

	@ManyToOne
	@JoinColumn(name="idProvincia")
	private Provincia provincia;

	public Canton() {
	}

	public Long getIdCanton() {
		return this.idCanton;
	}

	public void setIdCanton(Long idCanton) {
		this.idCanton = idCanton;
	}

	public String getCanton() {
		return this.canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


}