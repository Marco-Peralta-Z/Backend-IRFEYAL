package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "kit")
@NamedQueries({
    @NamedQuery(name = "Kit.findAll", query = "SELECT k FROM Kit k"),
    @NamedQuery(name = "Kit.findByid_kid", query = "SELECT k FROM Kit k WHERE k.id_kid = :id_kid"),
    @NamedQuery(name = "Kit.findByPrecioKit", query = "SELECT k FROM Kit k WHERE k.precioKit = :precioKit"),
    @NamedQuery(name = "Kit.findByPeriodo", query = "SELECT k FROM Kit k WHERE k.periodo = :periodo")})
public class Kit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_kid")
    private Long id_kid;
    
    @Column(name = "precio_kit")
    private Integer precioKit;
    
    @Column(name = "periodo")
    private String periodo;

    public Kit() {
    }

    public Kit(Long id_kid) {
        this.id_kid = id_kid;
    }

    public Long getid_kid() {
        return id_kid;
    }

    public void setid_kid(Long id_kid) {
        this.id_kid = id_kid;
    }

    public Integer getPrecioKit() {
        return precioKit;
    }

    public void setPrecioKit(Integer precioKit) {
        this.precioKit = precioKit;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_kid != null ? id_kid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kit)) {
            return false;
        }
        Kit other = (Kit) object;
        if ((this.id_kid == null && other.id_kid != null) || (this.id_kid != null && !this.id_kid.equals(other.id_kid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.Kit[ id_kid=" + id_kid + " ]";
    }
    
}
