package com.irfeyal.modelo.parametrizacionacademica;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.irfeyal.modelo.rolseguridad.RolUsuario;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long id_curso;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tipo_curso")
    private String tipo_curso;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fec_creacion")
    private Calendar fec_creacion;

    @ManyToOne
    @JoinColumn(name = "id_rol_usuario", unique = true)
    private RolUsuario id_rol_usuario;

    public Curso() {
        super();
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_curso() {
        return tipo_curso;
    }

    public void setTipo_curso(String tipo_curso) {
        this.tipo_curso = tipo_curso;
    }

    public Calendar getFecha_creacion() {
        return fec_creacion;
    }

    public void setFecha_creacion(Calendar fecha_creacion) {
        this.fec_creacion = fecha_creacion;
    }

	public RolUsuario getid_rol_usuario() {
		return id_rol_usuario;
	}

	public void setid_rol_usuario(RolUsuario id_rol_usuario) {
		this.id_rol_usuario = id_rol_usuario;
	}

    

}//fin()
