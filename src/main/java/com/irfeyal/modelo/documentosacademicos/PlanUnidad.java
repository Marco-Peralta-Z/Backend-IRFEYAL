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

import com.irfeyal.modelo.parametrizacionacademica.CursoParalelo;
import com.irfeyal.modelo.parametrizacionacademica.Horario;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;

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
	
	@ManyToOne
	@JoinColumn (name = "id_unidad")
	private Unidad unidad;
	
	@ManyToOne
	@JoinColumn (name = "id_horario")
	private Horario id_horario;
	
	//----------------
	@ManyToOne
	@JoinColumn (name = "id_curso_paralelo")
	private CursoParalelo id_curso_paralelo;
	
	//----------------
	
	@ManyToOne
	@JoinColumn (name = "id_modalidad")
	private Modalidad id_modalidad;
	
	@ManyToOne
	@JoinColumn (name = "id_periodo")
	private Periodo id_periodo;
	
	public PlanUnidad() {
	}

	public PlanUnidad(Long id_plan_unidad, String titulo_unidad, String objetivos, String contenidos, String criterios_evaluacion,
			String destrezas, Date fecha_inicio, Date fecha_fin, String estado, Unidad unidad, Horario id_horario,
			CursoParalelo id_curso_paralelo, Modalidad id_modalidad, Periodo id_periodo) {
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
		this.unidad = unidad;
		this.id_horario = id_horario;
		this.id_curso_paralelo = id_curso_paralelo;
		this.id_modalidad = id_modalidad;
		this.id_periodo = id_periodo;
	}

	public Long getIdPlanUnidad() {
		return id_plan_unidad;
	}

	public void setIdPlanUnidad(Long id_plan_unidad) {
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

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}

	public Horario getHorario() {
		return id_horario;
	}

	public void setHorario(Horario id_horario) {
		this.id_horario = id_horario;
	}

	public CursoParalelo getid_curso_paralelo() {
		return id_curso_paralelo;
	}

	public void setid_curso_paralelo(CursoParalelo id_curso_paralelo) {
		this.id_curso_paralelo = id_curso_paralelo;
	}

	public Modalidad getModalidad() {
		return id_modalidad;
	}

	public void setModalidad(Modalidad id_modalidad) {
		this.id_modalidad = id_modalidad;
	}

	public Periodo getPeriodo() {
		return id_periodo;
	}

	public void setPeriodo(Periodo id_periodo) {
		this.id_periodo = id_periodo;
	}
	

}