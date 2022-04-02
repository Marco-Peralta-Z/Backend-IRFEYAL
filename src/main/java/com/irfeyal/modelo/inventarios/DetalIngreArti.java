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
@Table(name = "detal_ingre_arti")
@NamedQueries({
    @NamedQuery(name = "DetalIngreArti.findAll", query = "SELECT d FROM DetalIngreArti d"),
    @NamedQuery(name = "DetalIngreArti.findByid_det_ingre_art", query = "SELECT d FROM DetalIngreArti d WHERE d.id_det_ingre_art = :id_det_ingre_art"),
    @NamedQuery(name = "DetalIngreArti.findByFechaingreso", query = "SELECT d FROM DetalIngreArti d WHERE d.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "DetalIngreArti.findByCantidad", query = "SELECT d FROM DetalIngreArti d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalIngreArti.findByObservacion", query = "SELECT d FROM DetalIngreArti d WHERE d.observacion = :observacion"),
    @NamedQuery(name = "DetalIngreArti.findByTipoIngreso", query = "SELECT d FROM DetalIngreArti d WHERE d.tipoIngreso = :tipoIngreso"),
    @NamedQuery(name = "DetalIngreArti.findByid_aprobacion", query = "SELECT d FROM DetalIngreArti d WHERE d.id_aprobacion = :id_aprobacion")})
public class DetalIngreArti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_det_ingre_art")
    private Long id_det_ingre_art;
    
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    
    @Column(name = "cantidad")
    private Long cantidad;
    
    @Column(name = "observacion")
    private String observacion;
    
    @Column(name = "tipo_ingreso")
    private String tipoIngreso;
    
    @Basic(optional = false)
    @Column(name = "id_aprobacion")
    private int id_aprobacion;
    

    public DetalIngreArti() {
    }

    public DetalIngreArti(Long id_det_ingre_art) {
        this.id_det_ingre_art = id_det_ingre_art;
    }

    public DetalIngreArti(Long id_det_ingre_art, int id_aprobacion) {
        this.id_det_ingre_art = id_det_ingre_art;
        this.id_aprobacion = id_aprobacion;
    }

    public Long getid_det_ingre_art() {
        return id_det_ingre_art;
    }

    public void setid_det_ingre_art(Long id_det_ingre_art) {
        this.id_det_ingre_art = id_det_ingre_art;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public int getid_aprobacion() {
        return id_aprobacion;
    }

    public void setid_aprobacion(int id_aprobacion) {
        this.id_aprobacion = id_aprobacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_det_ingre_art != null ? id_det_ingre_art.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalIngreArti)) {
            return false;
        }
        DetalIngreArti other = (DetalIngreArti) object;
        if ((this.id_det_ingre_art == null && other.id_det_ingre_art != null) || (this.id_det_ingre_art != null && !this.id_det_ingre_art.equals(other.id_det_ingre_art))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.DetalIngreArti[ id_det_ingre_art=" + id_det_ingre_art + " ]";
    }
    
}
