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

import com.irfeyal.modelo.rolseguridad.Empleado;

import lombok.Data;

@Data
@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_curso;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "tipo_curso")
	private String tipo_curso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;
	
	@PrePersist
	private void setDateFecha() {
		this.fecha_creacion = new Date();
	}
	
	//Relación con la tabla empleado
	@ManyToOne
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;

}
