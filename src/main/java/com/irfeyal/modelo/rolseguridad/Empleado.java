package com.irfeyal.modelo.rolseguridad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_empleado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empleado;

	private String cargo;

	@ManyToOne()
	@JoinColumn(name = "id_extension")
	private Extension extension;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_direcion")
	private Direccion direccion;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_telefono")
	private Telefono telefono;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_correo")
	private CorreoElectronico correo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_persona")
	private Persona id_persona;
	
	public Empleado() {
		super();
	}
	
	

	public Empleado(Long id_empleado) {
		super();
		this.id_empleado = id_empleado;
	}



	public Empleado(Long id_empleado, String cargo, Extension extension, Direccion direccion, Telefono telefono,
			CorreoElectronico correo, Persona id_persona) {
		super();
		this.id_empleado = id_empleado;
		this.cargo = cargo;
		this.extension = extension;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.id_persona = id_persona;
	}

	public Long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Extension getExtension() {
		return extension;
	}

	public void setExtension(Extension extension) {
		this.extension = extension;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}


	public CorreoElectronico getCorreo() {
		return correo;
	}

	public void setCorreo(CorreoElectronico correo) {
		this.correo = correo;
	}

	public Persona getId_persona() {
		return id_persona;
	}

	public void setId_persona(Persona id_persona) {
		this.id_persona = id_persona;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


}
