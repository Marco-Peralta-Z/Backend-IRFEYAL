package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irfeyal.modelo.rolseguridad.Empleado;

import lombok.Data;

//Modificado por: Josué Quichimbo. Fecha: 07/04/22. Hora: 16:38.

@Data
@Entity
@Table(name = "horario")
public class Horario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_horario;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "tiempo_inicio")
    private Date tiempo_inicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "tiempo_fin")
    private Date tiempo_fin;

    @Column(name = "dia")
    private int dia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Calendar fecha_creacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asignatura")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Asignatura id_asignatura;
    
    //Relación Curso-Horario, bidireccional, propietario Horario
    @ManyToMany
	@JoinTable(
			name = "curso_horario",
			joinColumns = { @JoinColumn(name = "id_horario") },
			inverseJoinColumns = { @JoinColumn(name = "id_curso") })
    private List<Curso> listaCursos = new ArrayList<Curso>();

    //Relación Horario-Empleado, unidireccional,propietario Horario
    @ManyToMany
    @JoinTable(
    		name= "horario_empleado",
    		joinColumns = {@JoinColumn(name= "id_horario")},
    		inverseJoinColumns = {@JoinColumn(name = "id_empleado")})
    private List<Empleado> listaEmpleados = new ArrayList<Empleado>();
    
    //Relación Asignatura-Horario, bidireccional
    @ManyToMany(mappedBy = "listaHorarios")
    private List<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
   
}
