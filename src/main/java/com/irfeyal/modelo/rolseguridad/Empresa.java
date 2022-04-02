package com.irfeyal.modelo.rolseguridad;
import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "empresa")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_empresa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empresa;

	private String nombre_empresa;

	@OneToOne
	@JoinColumn(name = "id_direccion")
	private Direccion id_direccion;

	//bi-directional many-to-one association to Telefono
	
	@OneToOne
	@JoinColumn(name = "id_telefono")
	private Telefono id_telefono;
	
	@OneToOne()
	@JoinColumn(name = "id_correo")
	private CorreoElectronico correo;

	public Empresa() {
	}

	public Long getid_empresa() {
		return id_empresa;
	}

	public void setid_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}


	

	public Direccion getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(Direccion id_direccion) {
		this.id_direccion = id_direccion;
	}

	public Telefono getId_telefono() {
		return id_telefono;
	}

	public void setId_telefono(Telefono id_telefono) {
		this.id_telefono = id_telefono;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CorreoElectronico getCorreo() {
		return correo;
	}

	public void setCorreo(CorreoElectronico correo) {
		this.correo = correo;
	}

	
}