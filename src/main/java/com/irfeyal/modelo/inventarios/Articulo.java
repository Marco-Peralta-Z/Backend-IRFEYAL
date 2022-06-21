package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_articulo")
	private Long id_articulo;
    
    @Column(name = "artinombre")
    private String artinombre;
    
    @Column(name = "articodigo")
    private String articodigo;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "artiprecio")
    private BigDecimal artiprecio;
    
    @Column(name = "artidescrip")
    private String artidescrip;
    
    @Column(name = "artiestado")
    private Boolean artiestado;
    
    @Column(name = "artimarca")
    private String artimarca;
    
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria cateId;
    
    @JoinColumn(name = "id_control_articulo", referencedColumnName = "id_control_articulo")
    @ManyToOne(optional = false)
    private ControlArticulo controlArticulo;
    
    public Articulo() {
    }

	public Long getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(Long id_articulo) {
		this.id_articulo = id_articulo;
	}

	public String getArtinombre() {
		return artinombre;
	}

	public void setArtinombre(String artinombre) {
		this.artinombre = artinombre;
	}

	public String getArticodigo() {
		return articodigo;
	}

	public void setArticodigo(String articodigo) {
		this.articodigo = articodigo;
	}

	public BigDecimal getArtiprecio() {
		return artiprecio;
	}

	public void setArtiprecio(BigDecimal artiprecio) {
		this.artiprecio = artiprecio;
	}

	public String getArtidescrip() {
		return artidescrip;
	}

	public void setArtidescrip(String artidescrip) {
		this.artidescrip = artidescrip;
	}


	public Boolean getArtiestado() {
		return artiestado;
	}

	public void setArtiestado(Boolean artiestado) {
		this.artiestado = artiestado;
	}

	public String getArtimarca() {
		return artimarca;
	}

	public void setArtimarca(String artimarca) {
		this.artimarca = artimarca;
	}

	public Categoria getCateId() {
		return cateId;
	}

	public void setCateId(Categoria cateId) {
		this.cateId = cateId;
	}

	public ControlArticulo getControlArticulo() {
		return controlArticulo;
	}

	public void setControlArticulo(ControlArticulo controlArticulo) {
		this.controlArticulo = controlArticulo;
	}


	

}
