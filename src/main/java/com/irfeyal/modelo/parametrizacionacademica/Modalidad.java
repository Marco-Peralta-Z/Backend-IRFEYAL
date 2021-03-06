package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "modalidad")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Modalidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_modalidad;

	@NotBlank(message = "Debe ingresar una descripcion para la Modalidad")
	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "hora_inicio")
	private String hora_inicio;

	@Column(name = "hora_fin")
	private String hora_fin;

	public Modalidad() {
		super();
	}

	
	
	public Modalidad(Long id_modalidad) {
		super();
		this.id_modalidad = id_modalidad;
	}



	public Modalidad(Long id_modalidad, String descripcion, String hora_inicio, String hora_fin) {
		super();
		this.id_modalidad = id_modalidad;
		this.descripcion = descripcion;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}

	public Long getId_modalidad() {
		return id_modalidad;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	public void setId_modalidad(Long id_modalidad) {
		this.id_modalidad = id_modalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Modalidad [descripcion=" + descripcion + ", id_modalidad=" + id_modalidad + ",hora_fin=" + hora_fin
				+ ",hora_inicio=" + hora_inicio + "]";
	}

}
