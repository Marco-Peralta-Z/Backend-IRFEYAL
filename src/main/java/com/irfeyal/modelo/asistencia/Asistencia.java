package com.irfeyal.modelo.asistencia;
import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.irfeyal.modelo.matricula.Estudiante;



@Entity
@Table(name = "asistencia")

public class Asistencia implements Serializable {
	  private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_asistencia")
	    private Long idAsistencia;

	    @Column(name = "estado_asis")
	    private String estadoAsis;
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





	public Asistencia(Long idAsistencia, String estadoAsis, Clase idClase, Estudiante idEstudiante) {
		super();
		this.idAsistencia = idAsistencia;
		this.estadoAsis = estadoAsis;
		this.idClase = idClase;
		this.idEstudiante = idEstudiante;
	}


	public Long getIdAsistencia() {
		return idAsistencia;
	}


	public void setIdAsistencia(Long idAsistencia) {
		this.idAsistencia = idAsistencia;
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
	
	 @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idAsistencia != null ? idAsistencia.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Asistencia)) {
	            return false;
	        }
	        Asistencia other = (Asistencia) object;
	        if ((this.idAsistencia == null && other.idAsistencia != null) || (this.idAsistencia != null && !this.idAsistencia.equals(other.idAsistencia))) {
	            return false;
	        }
	        return true;
	    }

}