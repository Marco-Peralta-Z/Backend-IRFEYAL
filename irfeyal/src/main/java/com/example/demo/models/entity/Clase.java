package com.example.demo.models.entity;
import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
@Entity
@Table(name = "clase")
public class Clase implements Serializable {
	   private static final long serialVersionUID = 1L;
	    @Id
	    @Column(name = "id_clase")
	    private Long idClase;
	    @Column(name = "fec_clase")  
	    private Date fecClase;
	    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	    @JoinColumn(name = "clase_id")
	    private List<Curso> Curso; 
	    @OneToOne(fetch = FetchType.LAZY)
	    private Modalidad id_modalidad;
	    @OneToOne(fetch = FetchType.LAZY)
	    private Periodo id_periodo;
	    @OneToOne(fetch = FetchType.LAZY)
	    private RolUsuario id_docente;
	    

	public Clase() {
		super();
	}

	public Clase(Long idClase) {
		super();
		this.idClase = idClase;
	}
	public Clase(Long idClase, Date fecClase) {
		super();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
