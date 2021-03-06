package com.irfeyal.modelo.matricula;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.irfeyal.modelo.inventarios.Kit;
import com.irfeyal.modelo.rolseguridad.CorreoElectronico;
import com.irfeyal.modelo.rolseguridad.Direccion;
import com.irfeyal.modelo.rolseguridad.Extension;
import com.irfeyal.modelo.rolseguridad.Persona;
import com.irfeyal.modelo.rolseguridad.Telefono;

@Entity
@Table(name="estudiantes")
@NamedQuery(name="Estudiante.findAll", query="SELECT e FROM Estudiante e")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_estudiante")
	private Long id_estudiante;

	@Column(name="estado_estudiante")
	private Boolean estadoEstudiante;

	@ManyToOne()
	@JoinColumn(name="id_extension")
	private Extension id_extension;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_persona")
	private Persona id_persona;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_correo")
	private CorreoElectronico correo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_direccion")
	private Direccion direccion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_telefono")
	private Telefono telefono;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "entrega_kit", joinColumns = { @JoinColumn(name = "id_estudiante") }, inverseJoinColumns = {
			@JoinColumn(name = "id_kit") })
	private List<Kit> listadoKits = new ArrayList<Kit>();


	public Estudiante() {
		super();
	}
	

	public Estudiante(Long id_estudiante) {
		super();
		this.id_estudiante = id_estudiante;
	}


	public Long getid_estudiante() {
		return this.id_estudiante;
	}

	public void setid_estudiante(Long id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public Boolean getEstadoEstudiante() {
		return this.estadoEstudiante;
	}

	public void setEstadoEstudiante(Boolean estadoEstudiante) {
		this.estadoEstudiante = estadoEstudiante;
	}

	public Extension getId_extension() {
		return id_extension;
	}

	public void setId_extension(Extension id_extension) {
		this.id_extension = id_extension;
	}

	public Persona getId_persona() {
		return id_persona;
	}

	public void setId_persona(Persona id_persona) {
		this.id_persona = id_persona;
	}

	public CorreoElectronico getCorreo() {
		return correo;
	}

	public void setCorreo(CorreoElectronico correo) {
		this.correo = correo;
	}

	public Telefono getTelefono() {
		return telefono;
	}

	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


	public List<Kit> getListadoKits() {
		return listadoKits;
	}


	public void setListadoKits(List<Kit> listadoKits) {
		this.listadoKits = listadoKits;
	}
	
	
}