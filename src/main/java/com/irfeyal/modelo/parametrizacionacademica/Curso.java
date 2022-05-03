package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.irfeyal.modelo.rolseguridad.Empleado;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_curso;

	@NotBlank(message = "La descripción del Curso no debe estar vacía")
	@Column(name = "descripcion")
	private String descripcion;

	@NotBlank(message = "El tipo de Curso no debe estar vacío")
	@Column(name = "tipo_curso")
	private String tipo_curso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@PrePersist
	private void setDateFecha() {
		this.fecha_creacion = new Date();
	}

	// Relación con la tabla empleado
	@ManyToOne
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;

	public Curso() {
	}

	public Long getId_curso() {
		return id_curso;
	}

	public void setId_curso(Long id_curso) {
		this.id_curso = id_curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo_curso() {
		return tipo_curso;
	}

	public void setTipo_curso(String tipo_curso) {
		this.tipo_curso = tipo_curso;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Curso [descripcion=" + descripcion + ", empleado=" + empleado + ", fecha_creacion=" + fecha_creacion
				+ ", id_curso=" + id_curso + ", tipo_curso=" + tipo_curso + "]";
	}

}
