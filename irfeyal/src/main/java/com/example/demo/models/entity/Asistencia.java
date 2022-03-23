package com.example.demo.models.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name = "asistencia")
@NamedQuery(name="Asistencia.findAll", query="SELECT a FROM Asistencia a")
public class Asistencia implements Serializable {
	  private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_asistencia")
	    private Long idAsistencia;

	    @Column(name = "estado_asis")
	    private boolean estadoAsis;
	   
	    @Column(name = "num_faltas")
	    private int numFaltas;
	    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
	    @ManyToOne(fetch = FetchType.LAZY)
	    private Clase idClase;
	    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
	    @ManyToOne(fetch = FetchType.LAZY)
	    private Estudiante idEstudiante;

	public Asistencia() {
		super();
	}


	public Asistencia(Long idAsistencia) {
		super();
		this.idAsistencia = idAsistencia;
	}

	public Asistencia(Long idAsistencia, boolean estadoAsis, int numFaltas, Clase idClase, Estudiante idEstudiante) {
		super();
		this.idAsistencia = idAsistencia;
		this.estadoAsis = estadoAsis;
		this.numFaltas = numFaltas;
		this.idClase = idClase;
		this.idEstudiante = idEstudiante;
	}

	public Long getIdAsistencia() {
		return idAsistencia;
	}


	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
	}



	public boolean isEstadoAsis() {
		return estadoAsis;
	}

	public void setEstadoAsis(boolean estadoAsis) {
		this.estadoAsis = estadoAsis;
	}

	public int getNumFaltas() {
		return numFaltas;
	}

	public void setNumFaltas(int numFaltas) {
		this.numFaltas = numFaltas;
	}

	public Clase getIdClase() {
		return idClase;
	}

	public void setIdClase(Clase idClase) {
		this.idClase = idClase;
	}

	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
