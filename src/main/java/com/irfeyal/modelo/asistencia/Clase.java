package com.irfeyal.modelo.asistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.rolseguridad.RolUsuario;


@Entity
@Table(name = "clase")
public class Clase implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_clase;

	@Column(name = "fecha_clase")
	private Date fechaClase;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_curso")
	private List<Curso> Curso;
	@OneToOne(fetch = FetchType.LAZY)
	private Modalidad id_modalidad;
	@OneToOne(fetch = FetchType.LAZY)
	private Periodo id_periodo;
	@OneToOne(fetch = FetchType.LAZY)
	private RolUsuario id_ro_usuario;

	public Clase() {
		super();
	}

	public Clase(Long id_clase) {
		super();
		this.id_clase = id_clase;
	}

	public Clase(Long id_clase, Date fechaClase) {
		super();
		this.id_clase = id_clase;
		this.fechaClase = fechaClase;
	}

	public Long getid_clase() {
		return id_clase;
	}

	public void setid_clase(Long id_clase) {
		this.id_clase = id_clase;
	}

	public Date getFechaClase() {
		return fechaClase;
	}

	public void setFechaClase(Date fechaClase) {
		this.fechaClase = fechaClase;
	}

}