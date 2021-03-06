package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Entity
@Table(name = "asignatura")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Asignatura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_asignatura;

	@NotBlank(message = "Debe ingresar una descripcion para la asignatura")
	@Column(name = "descripcion", length = 999)
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	// Relacion asignatura - empleado
	@ManyToMany
	@JoinTable(name = "asignatura_empleado", joinColumns = {
			@JoinColumn(name = "id_asignatura") }, inverseJoinColumns = { @JoinColumn(name = "id_empleado") })
	private List<Empleado> empleados = new ArrayList<>();

	@PrePersist
	private void setDateFecha() {
		this.fecha_creacion = new Date();
	}

	public Asignatura() {
		super();
	}
	
	

	public Asignatura(Long id_asignatura, String descripcion, Date fecha_creacion, List<Empleado> empleados) {
		this.id_asignatura = id_asignatura;
		this.descripcion = descripcion;
		this.fecha_creacion = fecha_creacion;
		this.empleados = empleados;
	}

	// CONSTRUCTOR TUTORIAS Y ASISTENCIAS
	public Asignatura(Long id_asignatura) {
		super();
		this.id_asignatura = id_asignatura;
	}
	// ------

	public Long getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(Long id_asignatura) {
		this.id_asignatura = id_asignatura;
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

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Asignatura [descripcion=" + descripcion + ", empleados=" + empleados + ", fecha_creacion="
				+ fecha_creacion + ", id_asignatura=" + id_asignatura + "]";
	}

}
