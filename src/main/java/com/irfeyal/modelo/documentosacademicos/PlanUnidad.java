package com.irfeyal.modelo.documentosacademicos;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Entity
@Table (name = "plan_unidad")
public class PlanUnidad implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_plan_unidad;
	
	private String titulo_unidad;
	private String objetivos;
	private String contenidos;
	private String criterios_evaluacion;
	private String destrezas;
	private Date fecha_inicio;
	private Date fecha_fin;
	private String estado;
	private String observaciones;
	
	@ManyToOne
	@JoinColumn (name = "id_unidad")
	private Unidad unidad;
	
	@ManyToOne
	@JoinColumn (name = "id_empleado")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn (name = "id_asignatura")
	private Asignatura asignatura;
	
	@ManyToOne
	@JoinColumn (name = "id_curso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn (name = "id_paralelo")
	private Paralelo paralelo;
	
	@ManyToOne
	@JoinColumn (name = "id_modalidad")
	private Modalidad modalidad;
	
	@ManyToOne
	@JoinColumn (name = "id_periodo")
	private Periodo periodo;
	
	public PlanUnidad() {
	}


	public PlanUnidad(Long id_plan_unidad, String titulo_unidad, String objetivos, String contenidos,
			String criterios_evaluacion, String destrezas, Date fecha_inicio, Date fecha_fin, String estado,
			String observaciones, Unidad unidad, Empleado empleado, Asignatura asignatura, Curso curso,
			Paralelo paralelo, Modalidad modalidad, Periodo periodo) {
		super();
		this.id_plan_unidad = id_plan_unidad;
		this.titulo_unidad = titulo_unidad;
		this.objetivos = objetivos;
		this.contenidos = contenidos;
		this.criterios_evaluacion = criterios_evaluacion;
		this.destrezas = destrezas;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.estado = estado;
		this.observaciones = observaciones;
		this.unidad = unidad;
		this.empleado = empleado;
		this.asignatura = asignatura;
		this.curso = curso;
		this.paralelo = paralelo;
		this.modalidad = modalidad;
		this.periodo = periodo;
	}


	public Long getId_plan_unidad() {
		return id_plan_unidad;
	}


	public void setId_plan_unidad(Long id_plan_unidad) {
		this.id_plan_unidad = id_plan_unidad;
	}


	public String getTitulo_unidad() {
		return titulo_unidad;
	}


	public void setTitulo_unidad(String titulo_unidad) {
		this.titulo_unidad = titulo_unidad;
	}


	public String getObjetivos() {
		return objetivos;
	}


	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
	}


	public String getContenidos() {
		return contenidos;
	}


	public void setContenidos(String contenidos) {
		this.contenidos = contenidos;
	}


	public String getCriterios_evaluacion() {
		return criterios_evaluacion;
	}


	public void setCriterios_evaluacion(String criterios_evaluacion) {
		this.criterios_evaluacion = criterios_evaluacion;
	}


	public String getDestrezas() {
		return destrezas;
	}


	public void setDestrezas(String destrezas) {
		this.destrezas = destrezas;
	}


	public Date getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public Date getFecha_fin() {
		return fecha_fin;
	}


	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	public Unidad getUnidad() {
		return unidad;
	}


	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public Asignatura getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public Paralelo getParalelo() {
		return paralelo;
	}


	public void setParalelo(Paralelo paralelo) {
		this.paralelo = paralelo;
	}


	public Modalidad getModalidad() {
		return modalidad;
	}


	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}


	public Periodo getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	
	

}