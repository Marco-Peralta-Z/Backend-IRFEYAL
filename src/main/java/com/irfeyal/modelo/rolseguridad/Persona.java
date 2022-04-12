package com.irfeyal.modelo.rolseguridad;
import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_persona")
	private Long id_persona;

	private String apellido;

	private String cedula;

	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	//bi-directional many-to-one association to Genero
	@OneToOne
	@JoinColumn(name="id_genero")
	private Genero genero;


	public Persona() {
	}


	public Long getid_persona() {
		return id_persona;
	}


	public void setid_persona(Long id_persona) {
		this.id_persona = id_persona;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}





}