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

	public Long getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}