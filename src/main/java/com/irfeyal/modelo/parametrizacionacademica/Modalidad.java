package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
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
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "modalidad")
public class Modalidad implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_modalidad;

    @Column(name = "descripcion")
    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "hora_inicio")
    private Date hora_inicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "hora_fin")
    private Date hora_fin;
    
    @ManyToMany
	@JoinTable(
			name = "modalidad_curso",
			joinColumns = { @JoinColumn(name = "id_modalidad") },
			inverseJoinColumns = { @JoinColumn(name = "id_curso") })
    private List<Curso> listaCursos;

    public Modalidad() {
        super();
    }

    public Long getId_modalidad() {
        return id_modalidad;
    }

    public void setId_modalidad(Long id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
    }

}//fin()
