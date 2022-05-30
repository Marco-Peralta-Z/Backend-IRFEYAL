package com.irfeyal.modelo.inventarios;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Long id_inventario;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    
    @Column(name = "fechaegreso")
    @Temporal(TemporalType.DATE)
    private Date fechaegreso;
    
    @Column(name = "disponibilidad")
    private Integer disponibilidad;
    
    @Column(name = "ingresado_por")
    private String ingresadoPor;
    
    @JoinColumn(name = "id_articulo", referencedColumnName = "id_articulo")
    @ManyToOne(optional = false)
    private Articulo id_Articulo;

    public Inventario() {
    }

	public Long getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(Long id_inventario) {
		this.id_inventario = id_inventario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public Date getFechaegreso() {
		return fechaegreso;
	}

	public void setFechaegreso(Date fechaegreso) {
		this.fechaegreso = fechaegreso;
	}

	public Integer getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getIngresadoPor() {
		return ingresadoPor;
	}

	public void setIngresadoPor(String ingresadoPor) {
		this.ingresadoPor = ingresadoPor;
	}

	public Articulo getId_Articulo() {
		return id_Articulo;
	}

	public void setId_Articulo(Articulo id_Articulo) {
		this.id_Articulo = id_Articulo;
	}

    
    
    
}
