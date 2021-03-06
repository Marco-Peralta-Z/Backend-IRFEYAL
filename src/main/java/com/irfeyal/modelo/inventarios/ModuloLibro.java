package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.irfeyal.modelo.parametrizacionacademica.Malla;

import javax.persistence.FetchType;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "modulo_libro")
public class ModuloLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo_libro")
    private Long id_modulo_libro;
    
    @Basic(optional = false)
    @Column(name = "cod_modulo")
    private String codModulo;
    
    @Column(name = "nombre_modulo")
    private String nombreModulo;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "stock_minimo")
    private Integer stockMinimo;
    
    @Column(name = "numero_modulo")
    private String numeroModulo;
    
	@ManyToMany(mappedBy = "listaModulos")
	private List<Kit> kits = new ArrayList<>();
    

    public ModuloLibro() {
    }
    
    
 
	public Long getId_modulo_libro() {
		return id_modulo_libro;
	}

	public void setId_modulo_libro(Long id_modulo_libro) {
		this.id_modulo_libro = id_modulo_libro;
	}

	

	public String getCodModulo() {
		return codModulo;
	}



	public void setCodModulo(String codModulo) {
		this.codModulo = codModulo;
	}



	public String getNombreModulo() {
		return nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getNumeroModulo() {
		return numeroModulo;
	}

	public void setNumeroModulo(String numeroModulo) {
		this.numeroModulo = numeroModulo;
	}


	@JsonIgnore
	public List<Kit> getKits() {
		return kits;
	}



	public void setKits(List<Kit> kits) {
		this.kits = kits;
	}



	public Integer getStockMinimo() {
		return stockMinimo;
	}



	public void setStockMinimo(Integer stockMinimo) {
		this.stockMinimo = stockMinimo;
	}




    
    
    
}
