package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "asignatura")
public class Asignatura implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_asignatura;

    @Column(name = "descripcion", length = 999)
    private String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Calendar fecha_creacion;
    
    @ManyToMany
	@JoinTable(
			name = "malla_asignatura",
			joinColumns = { @JoinColumn(name = "id_asignatura") },
			inverseJoinColumns = { @JoinColumn(name = "id_malla") })
    private List<Malla> listaMallas;

    public Asignatura() {
        super();
    }

    public Long getIdAsignatura() {
        return id_asignatura;
    }

    public void setIdAsignatura(Long id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Calendar getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Calendar fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

}//fin()