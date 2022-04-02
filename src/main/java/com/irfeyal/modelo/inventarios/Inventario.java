package com.irfeyal.modelo.inventarios;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "inventario")
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByid_inventario", query = "SELECT i FROM Inventario i WHERE i.id_inventario = :id_inventario"),
    @NamedQuery(name = "Inventario.findByCodigo", query = "SELECT i FROM Inventario i WHERE i.codigo = :codigo"),
    @NamedQuery(name = "Inventario.findByCantidad", query = "SELECT i FROM Inventario i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Inventario.findByFechaingreso", query = "SELECT i FROM Inventario i WHERE i.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "Inventario.findByFechaegreso", query = "SELECT i FROM Inventario i WHERE i.fechaegreso = :fechaegreso"),
    @NamedQuery(name = "Inventario.findByDisponibilidad", query = "SELECT i FROM Inventario i WHERE i.disponibilidad = :disponibilidad"),
    @NamedQuery(name = "Inventario.findByIngresadoPor", query = "SELECT i FROM Inventario i WHERE i.ingresadoPor = :ingresadoPor")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
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

    public Inventario(Long id_inventario) {
        this.id_inventario = id_inventario;
    }

    public Long getid_inventario() {
        return id_inventario;
    }

    public void setid_inventario(Long id_inventario) {
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

	public Integer getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
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


    public String getIngresadoPor() {
        return ingresadoPor;
    }

    public void setIngresadoPor(String ingresadoPor) {
        this.ingresadoPor = ingresadoPor;
    }

    public Articulo getid_Articulo() {
        return id_Articulo;
    }

    public void setid_Articulo(Articulo id_Articulo) {
        this.id_Articulo = id_Articulo;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_inventario != null ? id_inventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.id_inventario == null && other.id_inventario != null) || (this.id_inventario != null && !this.id_inventario.equals(other.id_inventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.Inventario[ id_inventario=" + id_inventario + " ]";
    }
    
}
