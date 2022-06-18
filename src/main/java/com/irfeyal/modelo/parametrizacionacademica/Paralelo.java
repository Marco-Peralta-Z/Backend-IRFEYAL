package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "paralelo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Paralelo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_paralelo;

	@NotBlank(message = "Debe ingresar una descripción para el Paralelo")
	@Column(name = "descripcion")
	private String descripcion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@PrePersist
	private void setFechaCreacion() {
		this.fecha_creacion = new Date();
	}

	public Paralelo(Long id_paralelo, String descripcion, Date fecha_creacion) {
		this.id_paralelo = id_paralelo;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
	}

	public Long getId_paralelo() {
		return id_paralelo;
	}

	public void setId_paralelo(Long id_paralelo) {
		this.id_paralelo = id_paralelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	@Override
	public String toString() {
		return "Paralelo [descripcion=" + descripcion + ", fecha_creacion=" + fecha_creacion + ", id_paralelo="
				+ id_paralelo + "]";
	}

}
