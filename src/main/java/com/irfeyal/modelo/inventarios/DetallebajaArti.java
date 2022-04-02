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
@Table(name = "detalle_baja_arti")
@NamedQueries({
    @NamedQuery(name = "DetallebajaArti.findAll", query = "SELECT d FROM DetallebajaArti d"),
    @NamedQuery(name = "DetallebajaArti.findByid_det_baja_art", query = "SELECT d FROM DetallebajaArti d WHERE d.id_det_baja_art = :id_det_baja_art"),
    @NamedQuery(name = "DetallebajaArti.findByCodigo", query = "SELECT d FROM DetallebajaArti d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "DetallebajaArti.findByCantidad", query = "SELECT d FROM DetallebajaArti d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetallebajaArti.findByMotivo", query = "SELECT d FROM DetallebajaArti d WHERE d.motivo = :motivo"),
    @NamedQuery(name = "DetallebajaArti.findByFechaBaja", query = "SELECT d FROM DetallebajaArti d WHERE d.fechaBaja = :fechaBaja")})
public class DetallebajaArti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_det_baja_art")
    private Long id_det_baja_art;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "cantidad")
    private Long cantidad;
    
    @Column(name = "motivo")
    private String motivo;
    
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    
    @JoinColumn(name = "id_inventario", referencedColumnName = "id_inventario")
    @ManyToOne(optional = false)
    private Inventario id_inventario;

    public DetallebajaArti() {
    }

    public DetallebajaArti(Long id_det_baja_art) {
        this.id_det_baja_art = id_det_baja_art;
    }

    public Long getid_det_baja_art() {
        return id_det_baja_art;
    }

    public void setid_det_baja_art(Long id_det_baja_art) {
        this.id_det_baja_art = id_det_baja_art;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Inventario getid_inventario() {
        return id_inventario;
    }

    public void setid_inventario(Inventario id_inventario) {
        this.id_inventario = id_inventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_det_baja_art != null ? id_det_baja_art.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallebajaArti)) {
            return false;
        }
        DetallebajaArti other = (DetallebajaArti) object;
        if ((this.id_det_baja_art == null && other.id_det_baja_art != null) || (this.id_det_baja_art != null && !this.id_det_baja_art.equals(other.id_det_baja_art))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.DetallebajaArti[ id_det_baja_art=" + id_det_baja_art + " ]";
    }
    
}
