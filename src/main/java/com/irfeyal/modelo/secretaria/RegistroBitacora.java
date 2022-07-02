package com.irfeyal.modelo.secretaria;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.irfeyal.modelo.rolseguridad.Empleado;

import java.sql.Timestamp;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
@Table (name = "registro_bitacora")
@NamedQuery(name="RegistroBitacora.findAll", query="SELECT r FROM RegistroBitacora r")
public class RegistroBitacora implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_registro_bitacora;
	
	@Column
	private String solicitante;
	@Column
	private String emisor;
	@Column
	private Timestamp fecha;
	@Column
	private Timestamp hora;
	@Column
	private String estado;
	
	@OneToOne()
	@JoinColumn(name = "id_empleado")
	private Empleado id_empleado;

	
	@OneToOne()
	@JoinColumn(name = "id_documento")
	private Documento documento;
	
	
	public RegistroBitacora() {
		
	}

	

	public Long getId_registro_bitacora() {
		return id_registro_bitacora;
	}

	public void setId_registro_bitacora(Long id_registro_bitacora) {
		this.id_registro_bitacora = id_registro_bitacora;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Timestamp getHora() {
		return hora;
	}

	public void setHora(Timestamp hora) {
		this.hora = hora;
	}

	public Empleado getid_empleado() {
		return id_empleado;
	}

	public void setid_empleado(Empleado id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
