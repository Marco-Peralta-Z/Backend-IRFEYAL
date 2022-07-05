package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irfeyal.modelo.matricula.Estudiante;
import com.irfeyal.modelo.parametrizacionacademica.Asignatura;
import com.irfeyal.modelo.parametrizacionacademica.Curso;
import com.irfeyal.modelo.parametrizacionacademica.Periodo;
import com.irfeyal.modelo.rolseguridad.Extension;


@Entity
@Table(name = "kit")
public class Kit implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_kit")
	private Long id_kit;
	
    @Column(name = "nombrekit")
    private String nombrekit;
    
    @Column(name = "precio_kit")
    private Integer precioKit;

   
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "ingreso_kit", joinColumns = { @JoinColumn(name = "id_kit") }, inverseJoinColumns = {
			@JoinColumn(name = "id_modulo_libro") })
	private List<ModuloLibro> listaModulos = new ArrayList<ModuloLibro>();
    
	@ManyToMany(mappedBy = "listadoKits")
	private List<Estudiante> estudiantes = new ArrayList<>();
    
    @OneToOne()
	@JoinColumn(name = "id_periodo")
	private Periodo periodo;
	
    @OneToOne()
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	
    public Kit() {
    }
    
	public Kit(Long id_kit, String nombrekit, Integer precioKit, List<ModuloLibro> listaModulos,
			List<Estudiante> estudiantes, Periodo periodo, Curso curso) {
		super();
		this.id_kit = id_kit;
		this.nombrekit = nombrekit;
		this.precioKit = precioKit;
		this.listaModulos = listaModulos;
		this.estudiantes = estudiantes;
		this.periodo = periodo;
		this.curso = curso;
	}







	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
	}


	public Long getId_kit() {
		return id_kit;
	}

	public void setId_kit(Long id_kit) {
		this.id_kit = id_kit;
	}

	public Integer getPrecioKit() {
		return precioKit;
	}

	public void setPrecioKit(Integer precioKit) {
		this.precioKit = precioKit;
	}
	
	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getNombrekit() {
		return nombrekit;
	}

	public void setNombrekit(String nombrekit) {
		this.nombrekit = nombrekit;
	}

	public List<ModuloLibro> getListaModulos() {
		return listaModulos;
	}

	public void setListaModulos(List<ModuloLibro> listaModulos) {
		this.listaModulos = listaModulos;
	}
	@JsonIgnore
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}






}
