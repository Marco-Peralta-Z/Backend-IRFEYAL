package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "periodo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Periodo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_periodo;

	@NotBlank(message = "Debe ingresar las actividades para el Periodo")
	@Column(name = "periodo_academico")
	private String periodo_academico;

	@NotNull(message = "Debe ingresar una fecha final para el Periodo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;

	@NotNull(message = "Debe ingresar una fecha final para el Periodo")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_fin")
	private Date fecha_fin;

	@NotNull(message = "Debe ingresar costo mensualidad del Periodo")
	@Column(name = "costo_mensualidad")
	private Double costo_mensualidad;

	@NotNull(message = "Debe ingresar el costo de la matrícula para el Periodo")
	@Column(name = "costo_matricula")
	private Double costo_matricula;

	@Column(name = "vigencia")
	private boolean vigencia;

	@Column(name = "ano_inicio")
	private String ano_inicio;

	@Column(name = "ano_fin")
	private String ano_fin;

	// Relación Periodo - Horario
	@ManyToMany
	@JoinTable(name = "periodo_horario", joinColumns = { @JoinColumn(name = "id_periodo") }, inverseJoinColumns = {
			@JoinColumn(name = "id_horario") })
	private List<Horario> listaHorario = new ArrayList<>();

	// Relación Periodo-Malla
	@ManyToOne
	@JoinColumn(name = "id_malla")
	private Malla malla;

	public Periodo() {
		super();
	}

	public Periodo(Long id_periodo, String periodo_academico, Date fecha_inicio, Date fecha_fin,
			Double costo_mensualidad, Double costo_matricula, boolean vigencia, String ano_inicio, String ano_fin,
			Malla malla) {
		this.id_periodo = id_periodo;
		this.periodo_academico = periodo_academico;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.costo_mensualidad = costo_mensualidad;
		this.costo_matricula = costo_matricula;
		this.vigencia = vigencia;
		this.ano_inicio = ano_inicio;
		this.ano_fin = ano_fin;
		this.malla = malla;
	}

	// CONSTRUCTOR TUTORIAS Y ASISTENCIA
	public Periodo(Long id_periodo) {
		super();
		this.id_periodo = id_periodo;
	}
	// --------

	public Long getId_periodo() {
		return id_periodo;
	}

	public void setId_periodo(Long id_periodo) {
		this.id_periodo = id_periodo;
	}

	public String getPeriodo_academico() {
		return periodo_academico;
	}

	public void setPeriodo_academico(String periodo_academico) {
		this.periodo_academico = periodo_academico;
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

	public Double getCosto_mensualidad() {
		return costo_mensualidad;
	}

	public void setCosto_mensualidad(Double costo_mensualidad) {
		this.costo_mensualidad = costo_mensualidad;
	}

	public Double getCosto_matricula() {
		return costo_matricula;
	}

	public void setCosto_matricula(Double costo_matricula) {
		this.costo_matricula = costo_matricula;
	}

	public boolean isVigencia() {
		return vigencia;
	}

	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}

	public String getAno_inicio() {
		return ano_inicio;
	}

	public void setAno_inicio(String ano_inicio) {
		this.ano_inicio = ano_inicio;
	}

	public String getAno_fin() {
		return ano_fin;
	}

	public void setAno_fin(String ano_fin) {
		this.ano_fin = ano_fin;
	}

	public List<Horario> getListaHorario() {
		return listaHorario;
	}

	public void setListaHorario(List<Horario> listaHorario) {
		this.listaHorario = listaHorario;
	}

	public Malla getMalla() {
		return malla;
	}

	public void setMalla(Malla malla) {
		this.malla = malla;
	}

	@Override
	public String toString() {
		return "Periodo [id_periodo=" + id_periodo + ", periodo_academico=" + periodo_academico + ", fecha_inicio="
				+ fecha_inicio + ", fecha_fin=" + fecha_fin + ", costo_mensualidad=" + costo_mensualidad
				+ ", costo_matricula=" + costo_matricula + ", vigencia=" + vigencia + ", ano_inicio=" + ano_inicio
				+ ", ano_fin=" + ano_fin + ", listaHorario=" + listaHorario + ", malla=" + malla + "]";
	}

}
