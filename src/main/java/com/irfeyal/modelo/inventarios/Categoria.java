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
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByid_categoria", query = "SELECT c FROM Categoria c WHERE c.id_categoria = :id_categoria"),
    @NamedQuery(name = "Categoria.findByCatenombre", query = "SELECT c FROM Categoria c WHERE c.catenombre = :catenombre"),
    @NamedQuery(name = "Categoria.findByCatedescri", query = "SELECT c FROM Categoria c WHERE c.catedescri = :catedescri"),
    @NamedQuery(name = "Categoria.findByCateestado", query = "SELECT c FROM Categoria c WHERE c.cateestado = :cateestado")})
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
    
    @Column(name = "cateestado")
    private String cateestado;
    
    public Categoria() {
    }

    public Categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Long getid_categoria() {
        return id_categoria;
    }

    public void setid_categoria(Long id_categoria) {
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

    public String getCateestado() {
        return cateestado;
    }

    public void setCateestado(String cateestado) {
        this.cateestado = cateestado;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_categoria != null ? id_categoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id_categoria == null && other.id_categoria != null) || (this.id_categoria != null && !this.id_categoria.equals(other.id_categoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.Categoria[ id_categoria=" + id_categoria + " ]";
    }
    
}
