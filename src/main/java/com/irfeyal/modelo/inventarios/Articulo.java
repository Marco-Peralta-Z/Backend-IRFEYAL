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
    private String artiestado;
    
    @Column(name = "artimarca")
    private String artimarca;
    
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria cateId;
    
    @JoinColumn(name = "id_det_ingre_art", referencedColumnName = "id_det_ingre_art")
    @ManyToOne(optional = false)
    private DetalIngreArti id_det_ingre_art;
    
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

	public String getArtiestado() {
		return artiestado;
	}

	public void setArtiestado(String artiestado) {
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

	public DetalIngreArti getId_det_ingre_art() {
		return id_det_ingre_art;
	}

	public void setId_det_ingre_art(DetalIngreArti id_det_ingre_art) {
		this.id_det_ingre_art = id_det_ingre_art;
	}

}
