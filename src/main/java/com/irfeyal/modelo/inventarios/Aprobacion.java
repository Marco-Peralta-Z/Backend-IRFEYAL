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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.irfeyal.modelo.rolseguridad.RolUsuario;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "aprobacion")
@NamedQueries({
    @NamedQuery(name = "Aprobacion.findAll", query = "SELECT a FROM Aprobacion a"),
    @NamedQuery(name = "Aprobacion.findByid_aprobacion", query = "SELECT a FROM Aprobacion a WHERE a.id_aprobacion = :id_aprobacion"),
    @NamedQuery(name = "Aprobacion.findByObservacionAproba", query = "SELECT a FROM Aprobacion a WHERE a.observacionAproba = :observacionAproba"),
    @NamedQuery(name = "Aprobacion.findByEstadoAproba", query = "SELECT a FROM Aprobacion a WHERE a.estadoAproba = :estadoAproba"),
    @NamedQuery(name = "Aprobacion.findByDetalleControl", query = "SELECT a FROM Aprobacion a WHERE a.detalleControl = :detalleControl"),
    @NamedQuery(name = "Aprobacion.findByFechaAprobacion", query = "SELECT a FROM Aprobacion a WHERE a.fechaAprobacion = :fechaAprobacion"),
    @NamedQuery(name = "Aprobacion.findByFechaControl", query = "SELECT a FROM Aprobacion a WHERE a.fechaControl = :fechaControl")})
public class Aprobacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aprobacion")
    private Long id_aprobacion;
    
    @Column(name = "observacion_aproba")
    private String observacionAproba;
    
    @Column(name = "estado_aproba")
    private Boolean estadoAproba;
    
    @Column(name = "detalle_control")
    private String detalleControl;
    
    @Column(name = "fecha_aprobacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAprobacion;
    
    @Column(name = "fecha_control")
    @Temporal(TemporalType.DATE)
    private Date fechaControl;
    
    @JoinColumn(name = "id_rol_usuario", referencedColumnName = "id_rol_usuario")
    @ManyToOne(optional = false)
    private RolUsuario idRoluAdmin;

    public Aprobacion() {
    }

    public Aprobacion(Long id_aprobacion) {
        this.id_aprobacion = id_aprobacion;
    }

    public Long getid_aprobacion() {
        return id_aprobacion;
    }

    public void setid_aprobacion(Long id_aprobacion) {
        this.id_aprobacion = id_aprobacion;
    }

    public String getObservacionAproba() {
        return observacionAproba;
    }

    public void setObservacionAproba(String observacionAproba) {
        this.observacionAproba = observacionAproba;
    }

    public Boolean getEstadoAproba() {
        return estadoAproba;
    }

    public void setEstadoAproba(Boolean estadoAproba) {
        this.estadoAproba = estadoAproba;
    }

    public String getDetalleControl() {
        return detalleControl;
    }

    public void setDetalleControl(String detalleControl) {
        this.detalleControl = detalleControl;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public Date getFechaControl() {
        return fechaControl;
    }

    public void setFechaControl(Date fechaControl) {
        this.fechaControl = fechaControl;
    }


    public RolUsuario getIdRoluAdmin() {
        return idRoluAdmin;
    }

    public void setIdRoluAdmin(RolUsuario idRoluAdmin) {
        this.idRoluAdmin = idRoluAdmin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_aprobacion != null ? id_aprobacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aprobacion)) {
            return false;
        }
        Aprobacion other = (Aprobacion) object;
        if ((this.id_aprobacion == null && other.id_aprobacion != null) || (this.id_aprobacion != null && !this.id_aprobacion.equals(other.id_aprobacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.Aprobacion[ id_aprobacion=" + id_aprobacion + " ]";
    }
    
}
