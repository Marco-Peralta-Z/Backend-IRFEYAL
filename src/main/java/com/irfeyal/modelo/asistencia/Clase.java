package com.irfeyal.modelo.asistencia;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Modalidad;
import com.irfeyal.modelo.parametrizacionacademica.Paralelo;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.rolseguridad.Empleado;
import com.sun.istack.NotNull;

@Entity
@Table(name = "clase")
public class Clase implements Serializable {
	   private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_clase")
	    private Long idClase;
	    @Column(name = "fec_clase")
	    @Temporal(TemporalType.DATE)
	    private Date fecClase;
	    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClase")
	    private Collection<Asistencia> asistenciaCollection;
	    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", nullable = false)
	    @ManyToOne(optional = false)
	    private Curso idCurso;
	    @OneToOne(fetch = FetchType.LAZY)
	    private Modalidad id_modalidad;
	    @OneToOne(fetch = FetchType.LAZY)
	    private Periodo id_periodo;
	    @JoinColumn(name = "id_paralelo", referencedColumnName = "id_paralelo", nullable = false)
	    @ManyToOne(optional = false)
	    private Paralelo idParalelo;
	    @JoinColumn(name = "id_asignatura", referencedColumnName = "id_asignatura", nullable = false)
	    @ManyToOne(optional = false)
	    private Asignatura idAsignatura;
	    @JoinColumn(name = "id_docente", referencedColumnName = "id_empleado", nullable = false)
	    @ManyToOne(optional = false)
	    private Empleado idDocente;
	    

	
	 public Clase() {
	    }

	    public Clase(Long idClase) {
	        this.idClase = idClase;
	    }

	    public Clase(Long idClase, Date fecClase) {
	        this.idClase = idClase;
	        this.fecClase = fecClase;
	    }

	    public Long getIdClase() {
	        return idClase;
	    }

	    public void setIdClase(Long idClase) {
	        this.idClase = idClase;
	    }

	    public Date getFecClase() {
	        return fecClase;
	    }

	    public void setFecClase(Date fecClase) {
	        this.fecClase = fecClase;
	    }

	    public Collection<Asistencia> getAsistenciaCollection() {
	        return asistenciaCollection;
	    }

	    public void setAsistenciaCollection(Collection<Asistencia> asistenciaCollection) {
	        this.asistenciaCollection = asistenciaCollection;
	    }

	    public Asignatura getIdAsignatura() {
	        return idAsignatura;
	    }

	    public void setIdAsignatura(Asignatura idAsignatura) {
	        this.idAsignatura = idAsignatura;
	    }

	    public Curso getIdCurso() {
	        return idCurso;
	    }

	    public void setIdCurso(Curso idCurso) {
	        this.idCurso = idCurso;
	    }

	    public Empleado getIdDocente() {
	        return idDocente;
	    }

	    public void setIdDocente(Empleado idDocente) {
	        this.idDocente = idDocente;
	    }

	    public Modalidad getIdModalidad() {
	        return id_modalidad;
	    }

	    public void setIdModalidad(Modalidad idModalidad) {
	        this.id_modalidad = idModalidad;
	    }

	    public Paralelo getIdParalelo() {
	        return idParalelo;
	    }

	    public void setIdParalelo(Paralelo idParalelo) {
	        this.idParalelo = idParalelo;
	    }

	    public Periodo getIdPeriodo() {
	        return id_periodo;
	    }

	    public void setIdPeriodo(Periodo idPeriodo) {
	        this.id_periodo = idPeriodo;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idClase != null ? idClase.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Clase)) {
	            return false;
	        }
	        Clase other = (Clase) object;
	        if ((this.idClase == null && other.idClase != null) || (this.idClase != null && !this.idClase.equals(other.idClase))) {
	            return false;
	        }
	        return true;
	    }
	

}
