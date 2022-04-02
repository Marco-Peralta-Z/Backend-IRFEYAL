package com.irfeyal.modelo.secretaria;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.rolseguridad.Direccion;
import com.irfeyal.modelo.rolseguridad.RolUsuario;

@Entity
@Table(name = "generar_certificado_matricula")

public class GenerarCertificadoMatricula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_generar_certificado_matricula;
	
	@Column
	private int id;
	@Column
	private String rectora;
	@Column
	private Date fecha;
	
	@OneToOne
	@JoinColumn(name = "id_rol_usuario")
	private RolUsuario id_rol_usuario;
	
	@OneToOne
	@JoinColumn(name = "id_matricula")
	private Matricula matricula;
	
	@OneToOne
	@JoinColumn(name = "id_direccion")
	private Direccion direccion;

	public GenerarCertificadoMatricula() {
		
	}

	public GenerarCertificadoMatricula(Long id_generar_certificado_matricula, int id, String rectora, Date fecha,
			RolUsuario id_rol_usuario, Matricula matricula, Direccion direccion) {
		super();
		this.id_generar_certificado_matricula = id_generar_certificado_matricula;
		this.id = id;
		this.rectora = rectora;
		this.fecha = fecha;
		this.id_rol_usuario = id_rol_usuario;
		this.matricula = matricula;
		this.direccion = direccion;
	}

	public Long getId_generar_certificado_matricula() {
		return id_generar_certificado_matricula;
	}

	public void setId_generar_certificado_matricula(Long id_generar_certificado_matricula) {
		this.id_generar_certificado_matricula = id_generar_certificado_matricula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRectora() {
		return rectora;
	}

	public void setRectora(String rectora) {
		this.rectora = rectora;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public RolUsuario getid_rol_usuario() {
		return id_rol_usuario;
	}

	public void setid_rol_usuario(RolUsuario id_rol_usuario) {
		this.id_rol_usuario = id_rol_usuario;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}
