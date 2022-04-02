package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
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

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "articulo")
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByid_articulo", query = "SELECT a FROM Articulo a WHERE a.id_articulo = :id_articulo"),
    @NamedQuery(name = "Articulo.findByArtinombre", query = "SELECT a FROM Articulo a WHERE a.artinombre = :artinombre"),
    @NamedQuery(name = "Articulo.findByArticodigo", query = "SELECT a FROM Articulo a WHERE a.articodigo = :articodigo"),
    @NamedQuery(name = "Articulo.findByArtiprecio", query = "SELECT a FROM Articulo a WHERE a.artiprecio = :artiprecio"),
    @NamedQuery(name = "Articulo.findByArtidescrip", query = "SELECT a FROM Articulo a WHERE a.artidescrip = :artidescrip"),
    @NamedQuery(name = "Articulo.findByArtiestado", query = "SELECT a FROM Articulo a WHERE a.artiestado = :artiestado"),
    @NamedQuery(name = "Articulo.findByArtimarca", query = "SELECT a FROM Articulo a WHERE a.artimarca = :artimarca")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
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

    public Articulo(Long id_articulo) {
        this.id_articulo = id_articulo;
    }

    public Long getid_articulo() {
        return id_articulo;
    }

    public void setid_articulo(Long id_articulo) {
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

    public DetalIngreArti getDeinarictId() {
        return id_det_ingre_art;
    }

    public void setDeinarictId(DetalIngreArti id_det_ingre_art) {
        this.id_det_ingre_art = id_det_ingre_art;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_articulo != null ? id_articulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.id_articulo == null && other.id_articulo != null) || (this.id_articulo != null && !this.id_articulo.equals(other.id_articulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.Articulo[ id_articulo=" + id_articulo + " ]";
    }
    
}
