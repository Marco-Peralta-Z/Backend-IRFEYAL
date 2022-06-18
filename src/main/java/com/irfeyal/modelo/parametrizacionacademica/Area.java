package com.irfeyal.modelo.parametrizacionacademica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "area")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id_area;

    @NotBlank(message = "Debe ingresar una descripcion para el area")
    @Column(name = "descripcion", length = 999)
    private String descripcion;

    // Relacion Area - Asignatura
    @ManyToMany
    @JoinTable(name = "area_asignatura", joinColumns = { @JoinColumn(name = "id_area") }, inverseJoinColumns = {
            @JoinColumn(name = "id_asignatura") })
    private List<Asignatura> listaAsignaturas = new ArrayList<>();
    
    public Area(Long id_area, String descripcion, List<Asignatura> listaAsignaturas) {
		this.id_area = id_area;
		this.descripcion = descripcion;
		this.listaAsignaturas = listaAsignaturas;
	}

	public Long getId_area() {
        return id_area;
    }

    public void setId_area(Long id_area) {
        this.id_area = id_area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    @Override
    public String toString() {
        return "Area [descripcion=" + descripcion + ", id_area=" + id_area + ", listaAsignaturas=" + listaAsignaturas
                + "]";
    }

}
