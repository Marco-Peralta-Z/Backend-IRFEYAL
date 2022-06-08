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
    
    @Column(name = "cate_nombre")
    private String cateNombre;
    
    @Column(name = "cate_codigo")
    private String cateCodigo;
    

    public Categoria() {
    }

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getCateNombre() {
		return cateNombre;
	}

	public void setCateNombre(String cateNombre) {
		this.cateNombre = cateNombre;
	}

	public String getCateCodigo() {
		return cateCodigo;
	}

	public void setCateCodigo(String cateCodigo) {
		this.cateCodigo = cateCodigo;
	}

	




}
