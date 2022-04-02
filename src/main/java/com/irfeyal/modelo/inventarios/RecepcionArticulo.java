package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "recepcion_articulo")
@NamedQueries({
    @NamedQuery(name = "RecepcionArticulo.findAll", query = "SELECT r FROM RecepcionArticulo r"),
    @NamedQuery(name = "RecepcionArticulo.findByid_recepcion_art", query = "SELECT r FROM RecepcionArticulo r WHERE r.id_recepcion_art = :id_recepcion_art"),
    @NamedQuery(name = "RecepcionArticulo.findByFecha", query = "SELECT r FROM RecepcionArticulo r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "RecepcionArticulo.findByCodigo", query = "SELECT r FROM RecepcionArticulo r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "RecepcionArticulo.findByDetallerecep", query = "SELECT r FROM RecepcionArticulo r WHERE r.detallerecep = :detallerecep")})
public class RecepcionArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_recepcion_art")
    private Long id_recepcion_art;
    
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "detallerecep")
    private String detallerecep;
    @JoinColumn(name = "id_det_ingre_art", referencedColumnName = "id_det_ingre_art")
    @ManyToOne(optional = false)
    private DetalIngreArti id_det_ingre_art;

    public RecepcionArticulo() {
    }

    public RecepcionArticulo(Long id_recepcion_art) {
        this.id_recepcion_art = id_recepcion_art;
    }

    public Long getid_recepcion_art() {
        return id_recepcion_art;
    }

    public void setid_recepcion_art(Long id_recepcion_art) {
        this.id_recepcion_art = id_recepcion_art;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetallerecep() {
        return detallerecep;
    }

    public void setDetallerecep(String detallerecep) {
        this.detallerecep = detallerecep;
    }

    public DetalIngreArti getid_det_ingre_art() {
        return id_det_ingre_art;
    }

    public void setid_det_ingre_art(DetalIngreArti id_det_ingre_art) {
        this.id_det_ingre_art = id_det_ingre_art;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_recepcion_art != null ? id_recepcion_art.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecepcionArticulo)) {
            return false;
        }
        RecepcionArticulo other = (RecepcionArticulo) object;
        if ((this.id_recepcion_art == null && other.id_recepcion_art != null) || (this.id_recepcion_art != null && !this.id_recepcion_art.equals(other.id_recepcion_art))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.RecepcionArticulo[ id_recepcion_art=" + id_recepcion_art + " ]";
    }
    
}
