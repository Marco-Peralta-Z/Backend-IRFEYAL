package com.irfeyal.modelo.secretaria;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.irfeyal.modelo.matricula.Matricula;
import com.irfeyal.modelo.rolseguridad.Direccion;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Entity
@Table(name = "generar_certificado_matricula")
@NamedQuery(name="GenerarCertificadoMatricula.findall", query = "SELECT g FROM GenerarCertificadoMatricula g")
public class GenerarCertificadoMatricula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_generar_certificado_matricula;

	@Column
	private String rectora;
	@Column
	private Date fecha;
	
	@OneToOne
	@JoinColumn(name = "id_empleado")
	private Empleado id_empleado;
	
	@OneToOne
	@JoinColumn(name = "id_matricula")
	private Matricula matricula;
	

	public GenerarCertificadoMatricula() {
		
	}


	public Long getId_generar_certificado_matricula() {
		return id_generar_certificado_matricula;
	}

	public void setId_generar_certificado_matricula(Long id_generar_certificado_matricula) {
		this.id_generar_certificado_matricula = id_generar_certificado_matricula;
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

	public Empleado getid_empleado() {
		return id_empleado;
	}

	public void setid_empleado(Empleado id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	
}
