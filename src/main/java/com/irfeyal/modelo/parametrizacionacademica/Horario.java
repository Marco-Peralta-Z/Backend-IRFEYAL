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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
	@Column(name = "tiempo_inicio")
	private String tiempo_inicio;

	@NotNull(message = "Debe ingresar el tiempo de fin")
	@Column(name = "tiempo_fin")
	private String tiempo_fin;

	@NotNull(message = "Debe ingresar un dia para el Horario")
	@Min(value = 1, message = "El día no debe ser menor que 1")
	@Max(value = 7, message = "El día no debe ser mayor a 7")
	@Column(name = "dia")
	private int dia;

	// Relacion horario_empleado
	@ManyToOne
	@JoinColumn(name = "id_empleado")
	private Empleado id_empleado;

	// Relacion horario_asignatura
	@ManyToOne
	@JoinColumn(name = "id_asignatura")
	private Asignatura id_asignatura;

	// Relacion horario_tutor
	@ManyToOne
	@JoinColumn(name = "id_tutor")
	private Tutor id_tutor;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fecha_creacion;

	@PrePersist
	private void setDateFecha() {
		this.fecha_creacion = new Date();
	}

	public Long getId_horario() {
		return id_horario;
	}

	public void setId_horario(Long id_horario) {
		this.id_horario = id_horario;
	}

	public String getTiempo_inicio() {
		return tiempo_inicio;
	}

	public void setTiempo_inicio(String tiempo_inicio) {
		this.tiempo_inicio = tiempo_inicio;
	}

	public String getTiempo_fin() {
		return tiempo_fin;
	}

	public void setTiempo_fin(String tiempo_fin) {
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

	public Empleado getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Empleado id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Asignatura getId_asignatura() {
		return id_asignatura;
	}

	public void setId_asignatura(Asignatura id_asignatura) {
		this.id_asignatura = id_asignatura;
	}

	public Tutor getId_tutor() {
		return id_tutor;
	}

	public void setId_tutor(Tutor id_tutor) {
		this.id_tutor = id_tutor;
	}

	@Override
	public String toString() {
		return "Horario [dia=" + dia + ", fecha_creacion=" + fecha_creacion + ", id_horario=" + id_horario
				+ ", id_asignatura=" + id_asignatura + ", id_empleado=" + id_empleado + ", tiempo_fin=" + tiempo_fin
				+ ", tiempo_inicio=" + tiempo_inicio + ",id_tutor=" + id_tutor + "]";
	}

}
