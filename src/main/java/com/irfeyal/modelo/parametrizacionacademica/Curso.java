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

import lombok.Data;

//Modificado por: Josué Quichimbo. Fecha: 07/04/22. Hora: 16:35

@Data
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

}
