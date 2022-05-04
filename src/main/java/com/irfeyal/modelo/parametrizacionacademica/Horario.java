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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irfeyal.modelo.rolseguridad.Empleado;

@Entity
@Table(name = "horario")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Horario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_horario;

	@NotNull(message = "Debe ingresar el tiempo de inicio")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "tiempo_inicio")
	private Date tiempo_inicio;

	@NotNull(message = "Debe ingresar el tiempo de fin")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@Column(name = "tiempo_fin")
	private Date tiempo_fin;

	@NotNull(message = "Debe ingresar un dia para el Horario")
	@Min(value = 1, message = "El día no debe ser menor que 1")
	@Max(value = 7, message = "El día no debe ser mayor a 7")
	@Column(name = "dia")
	private int dia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@PrePersist
	private void setDateFecha() {
		this.fecha_creacion = new Date();
	}

	// Relación Curso-Horario
	@ManyToMany
	@JoinTable(name = "curso_horario", joinColumns = { @JoinColumn(name = "id_horario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso") })
	private List<Curso> listaCursos = new ArrayList<>();

	// Relación horario_empleado
	@ManyToMany
	@JoinTable(name = "horario_empleado", joinColumns = { @JoinColumn(name = "id_horario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_empleado") })
	private List<Empleado> listaEmpleados = new ArrayList<>();

	public Long getId_horario() {
		return id_horario;
	}

	public void setId_horario(Long id_horario) {
		this.id_horario = id_horario;
	}

	public Date getTiempo_inicio() {
		return tiempo_inicio;
	}

	public void setTiempo_inicio(Date tiempo_inicio) {
		this.tiempo_inicio = tiempo_inicio;
	}

	public Date getTiempo_fin() {
		return tiempo_fin;
	}

	public void setTiempo_fin(Date tiempo_fin) {
		this.tiempo_fin = tiempo_fin;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public String toString() {
		return "Horario [dia=" + dia + ", fecha_creacion=" + fecha_creacion + ", id_horario=" + id_horario
				+ ", listaCursos=" + listaCursos + ", listaEmpleados=" + listaEmpleados + ", tiempo_fin=" + tiempo_fin
				+ ", tiempo_inicio=" + tiempo_inicio + "]";
	}

}
