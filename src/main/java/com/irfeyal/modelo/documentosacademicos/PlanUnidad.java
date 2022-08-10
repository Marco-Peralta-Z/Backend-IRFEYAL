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
	private Date fecha_creacion;
	private Date fecha_inicio;
	private Date fecha_fin;
	private Long num_periodos;
	
	@Column(name = "objetivos", length = 10485760)
	private String objetivos;
	
	@Column(name = "criterios_evaluacion", length = 10485760)
	private String criterios_evaluacion;
	
	@Column(name = "destrezas", length = 10485760)
	private String destrezas;
	
	@Column(name = "act_experiencia", length = 10485760)
	private String act_experiencia;
	
	@Column(name = "act_reflexion", length = 10485760)
	private String act_reflexion;
	
	@Column(name = "act_conceptualizacion", length = 10485760)
	private String act_conceptualizacion;
	
	@Column(name = "act_aplicacion", length = 10485760)
	private String act_aplicacion;
	
	@Column(name = "recursos", length = 10485760)
	private String recursos;
	
	@Column(name = "indicadores", length = 10485760)
	private String indicadores;
	
	@Column(name = "tecnicas", length = 10485760)
	private String tecnicas;
	
	@Column(name = "adaptaciones_curriculares", length = 10485760)
	private String adaptaciones_curriculares;
	
	@Column(name = "adap_necesidad_educativa", length = 10485760)
	private String adap_necesidad_educativa;
	
	@Column(name = "especificacion_nesesidad", length = 10485760)
	private String especificacion_nesesidad;
	
	private String estado;
	
	@Column(name = "observaciones", length = 10485760)
	private String observaciones;
	
	private String coor_area;
	private Date fecha_revision;
	
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

	public PlanUnidad(Long id_plan_unidad, String titulo_unidad, Date fecha_creacion, Date fecha_inicio, Date fecha_fin,
			Long num_periodos, String objetivos, String criterios_evaluacion, String destrezas, String act_experiencia,
			String act_reflexion, String act_conceptualizacion, String act_aplicacion, String recursos,
			String indicadores, String tecnicas, String adaptaciones_curriculares, String adap_necesidad_educativa,
			String especificacion_nesesidad, String estado, String observaciones, String coor_area,
			Date fecha_revision, Unidad unidad, Empleado empleado, Asignatura asignatura, Curso curso,
			Paralelo paralelo, Modalidad modalidad, Periodo periodo) {
		super();
		this.id_plan_unidad = id_plan_unidad;
		this.titulo_unidad = titulo_unidad;
		this.fecha_creacion = fecha_creacion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.num_periodos = num_periodos;
		this.objetivos = objetivos;
		this.criterios_evaluacion = criterios_evaluacion;
		this.destrezas = destrezas;
		this.act_experiencia = act_experiencia;
		this.act_reflexion = act_reflexion;
		this.act_conceptualizacion = act_conceptualizacion;
		this.act_aplicacion = act_aplicacion;
		this.recursos = recursos;
		this.indicadores = indicadores;
		this.tecnicas = tecnicas;
		this.adaptaciones_curriculares = adaptaciones_curriculares;
		this.adap_necesidad_educativa = adap_necesidad_educativa;
		this.especificacion_nesesidad = especificacion_nesesidad;
		this.estado = estado;
		this.observaciones = observaciones;
		this.coor_area= coor_area;
		this.fecha_revision = fecha_revision;
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

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
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

	public Long getNum_periodos() {
		return num_periodos;
	}

	public void setNum_periodos(Long num_periodos) {
		this.num_periodos = num_periodos;
	}

	public String getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(String objetivos) {
		this.objetivos = objetivos;
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

	public String getAct_experiencia() {
		return act_experiencia;
	}

	public void setAct_experiencia(String act_experiencia) {
		this.act_experiencia = act_experiencia;
	}

	public String getAct_reflexion() {
		return act_reflexion;
	}

	public void setAct_reflexion(String act_reflexion) {
		this.act_reflexion = act_reflexion;
	}

	public String getAct_conceptualizacion() {
		return act_conceptualizacion;
	}

	public void setAct_conceptualizacion(String act_conceptualizacion) {
		this.act_conceptualizacion = act_conceptualizacion;
	}

	public String getAct_aplicacion() {
		return act_aplicacion;
	}

	public void setAct_aplicacion(String act_aplicacion) {
		this.act_aplicacion = act_aplicacion;
	}

	public String getRecursos() {
		return recursos;
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
	}

	public String getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(String indicadores) {
		this.indicadores = indicadores;
	}

	public String getTecnicas() {
		return tecnicas;
	}

	public void setTecnicas(String tecnicas) {
		this.tecnicas = tecnicas;
	}

	public String getAdaptaciones_curriculares() {
		return adaptaciones_curriculares;
	}

	public void setAdaptaciones_curriculares(String adaptaciones_curriculares) {
		this.adaptaciones_curriculares = adaptaciones_curriculares;
	}

	public String getAdap_necesidad_educativa() {
		return adap_necesidad_educativa;
	}

	public void setAdap_necesidad_educativa(String adap_necesidad_educativa) {
		this.adap_necesidad_educativa = adap_necesidad_educativa;
	}

	public String getEspecificacion_nesesidad() {
		return especificacion_nesesidad;
	}

	public void setEspecificacion_nesesidad(String especificacion_nesesidad) {
		this.especificacion_nesesidad = especificacion_nesesidad;
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

	public String getCoor_area() {
		return coor_area;
	}

	public void setCoor_area(String coor_area) {
		this.coor_area= coor_area;
	}

	public Date getFecha_revision() {
		return fecha_revision;
	}

	public void setFecha_revision(Date fecha_revision) {
		this.fecha_revision = fecha_revision;
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