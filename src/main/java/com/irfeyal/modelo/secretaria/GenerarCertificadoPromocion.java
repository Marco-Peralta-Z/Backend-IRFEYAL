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

import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.irfeyal.modelo.tutorias.Registro;

@Entity
@Table(name = "generar_certificado_promocion")
@NamedQuery(name="GenerarCertificadoPromocion.findall", query = "SELECT p FROM GenerarCertificadoPromocion p")
public class GenerarCertificadoPromocion implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_generar_certificado_promocion;
	
	@Column
	private float promedio_general_num;
	@Column
	private String promedio_general_let;
	@Column
	private String descripcion;
	@Column
	private Date fecha;
	@Column
	private String rectora;
	
	@OneToOne
	@JoinColumn(name="id_empleado")
	private Empleado id_empleado;
	
	@OneToOne
	@JoinColumn(name="id_registro")
	private Registro registro;
	
	@OneToOne
	@JoinColumn(name="id_curso")
	private Curso curso;

	public GenerarCertificadoPromocion() {
		
	}


	public Long getId_generar_certificado_promocion() {
		return id_generar_certificado_promocion;
	}

	public void setId_generar_certificado_promocion(Long id_generar_certificado_promocion) {
		this.id_generar_certificado_promocion = id_generar_certificado_promocion;
	}

	public float getPromedio_general_num() {
		return promedio_general_num;
	}

	public void setPromedio_general_num(float promedio_general_num) {
		this.promedio_general_num = promedio_general_num;
	}

	public String getPromedio_general_let() {
		return promedio_general_let;
	}

	public void setPromedio_general_let(String promedio_general_let) {
		this.promedio_general_let = promedio_general_let;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getRectora() {
		return rectora;
	}

	public void setRectora(String rectora) {
		this.rectora = rectora;
	}

	public Empleado getid_empleado() {
		return id_empleado;
	}

	public void setid_empleado(Empleado id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
