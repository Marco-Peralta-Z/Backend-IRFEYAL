package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria")
    private Long id_categoria;
    
    @Column(name = "catenombre")
    private String catenombre;
    
    @Column(name = "catedescri")
    private String catedescri;
    

    public Categoria() {
    }

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getCatenombre() {
		return catenombre;
	}

	public void setCatenombre(String catenombre) {
		this.catenombre = catenombre;
	}

	public String getCatedescri() {
		return catedescri;
	}

	public void setCatedescri(String catedescri) {
		this.catedescri = catedescri;
	}



}
