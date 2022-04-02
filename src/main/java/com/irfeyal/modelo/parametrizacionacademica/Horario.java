package com.irfeyal.modelo.parametrizacionacademica;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.irfeyal.modelo.rolseguridad.RolUsuario;

import java.io.Serializable;
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
    
    @ManyToMany
	@JoinTable(
			name = "cursos_horario",
			joinColumns = { @JoinColumn(name = "id_horario") },
			inverseJoinColumns = { @JoinColumn(name = "id_curso") })
    private List<Curso> listaCursos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private RolUsuario id_rol_usuario;

    public Horario() {
        super();
    }

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

    public Calendar getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Calendar fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Asignatura getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Asignatura id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public RolUsuario getid_rol_usuario() {
        return id_rol_usuario;
    }

    public void setId_rol_usuario(RolUsuario id_rol_usuario) {
        this.id_rol_usuario = id_rol_usuario;
    }

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

}//fin()
