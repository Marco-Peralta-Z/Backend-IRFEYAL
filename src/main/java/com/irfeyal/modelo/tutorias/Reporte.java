package com.irfeyal.modelo.tutorias;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reporte")


public class Reporte implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_reporte;
	
	@Column
	private String nombre_reporte;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha_reporte;

	public Reporte() {
	}

	public Reporte(Long id_reporte, String nombre_reporte, Date fecha_reporte) {
		super();
		this.id_reporte = id_reporte;
		this.nombre_reporte = nombre_reporte;
		this.fecha_reporte = fecha_reporte;
	}

	public Long getId_reporte() {
		return id_reporte;
	}

	public void setId_reporte(Long id_reporte) {
		this.id_reporte = id_reporte;
	}

	public String getNombre_reporte() {
		return nombre_reporte;
	}

	public void setNombre_reporte(String nombre_reporte) {
		this.nombre_reporte = nombre_reporte;
	}

	public Date getFecha_reporte() {
		return fecha_reporte;
	}

	public void setFecha_reporte(Date fecha_reporte) {
		this.fecha_reporte = fecha_reporte;
	}
	
	
	
}
