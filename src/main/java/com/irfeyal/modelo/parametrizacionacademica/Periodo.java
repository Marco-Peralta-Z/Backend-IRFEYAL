package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	// Relación Periodo-Malla
	@ManyToOne
	@JoinColumn(name = "id_malla", nullable = true)
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

	public boolean isVigencia() {
		return vigencia;
	}

	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}

	public Malla getMalla() {
		return malla;
	}

	public void setMalla(Malla malla) {
		this.malla = malla;
	}

	@Override
	public String toString() {
		return "Periodo [ano_fin=" + ano_fin + ", ano_inicio=" + ano_inicio + ", costo_matricula=" + costo_matricula
				+ ", costo_mensualidad=" + costo_mensualidad + ", fecha_fin=" + fecha_fin + ", fecha_inicio="
				+ fecha_inicio + ", id_periodo=" + id_periodo + ", malla=" + malla + ", periodo_academico="
				+ periodo_academico + ", vigencia=" + vigencia + "]";
	}

}
