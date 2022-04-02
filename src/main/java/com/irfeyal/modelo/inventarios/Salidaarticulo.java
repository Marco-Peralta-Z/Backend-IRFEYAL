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
@Table(name = "salida_articulo")
@NamedQueries({
    @NamedQuery(name = "Salidaarticulo.findAll", query = "SELECT s FROM Salidaarticulo s"),
    @NamedQuery(name = "Salidaarticulo.findByid_salida_art", query = "SELECT s FROM Salidaarticulo s WHERE s.id_salida_art = :id_salida_art"),
    @NamedQuery(name = "Salidaarticulo.findByFechaSalida", query = "SELECT s FROM Salidaarticulo s WHERE s.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Salidaarticulo.findByCodigo", query = "SELECT s FROM Salidaarticulo s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Salidaarticulo.findByDetallesalida", query = "SELECT s FROM Salidaarticulo s WHERE s.detallesalida = :detallesalida"),
    @NamedQuery(name = "Salidaarticulo.findByDebarticuloId", query = "SELECT s FROM Salidaarticulo s WHERE s.debarticuloId = :debarticuloId")})
public class Salidaarticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salida_art")
    private Long id_salida_art;
    
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "detallesalida")
    private String detallesalida;
    
    @Basic(optional = false)
    @Column(name = "debarticulo_id")
    private int debarticuloId;
    
    @JoinColumn(name = "id_aprobacion", referencedColumnName = "id_aprobacion")
    @ManyToOne(optional = false)
    private Aprobacion id_aprobacion;

    public Salidaarticulo() {
    }

    public Salidaarticulo(Long id_salida_art) {
        this.id_salida_art = id_salida_art;
    }

    public Salidaarticulo(Long id_salida_art, int debarticuloId) {
        this.id_salida_art = id_salida_art;
        this.debarticuloId = debarticuloId;
    }

    public Long getid_salida_art() {
        return id_salida_art;
    }

    public void setid_salida_art(Long id_salida_art) {
        this.id_salida_art = id_salida_art;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDetallesalida() {
        return detallesalida;
    }

    public void setDetallesalida(String detallesalida) {
        this.detallesalida = detallesalida;
    }

    public int getDebarticuloId() {
        return debarticuloId;
    }

    public void setDebarticuloId(int debarticuloId) {
        this.debarticuloId = debarticuloId;
    }

    public Aprobacion getid_aprobacion() {
        return id_aprobacion;
    }

    public void setid_aprobacion(Aprobacion id_aprobacion) {
        this.id_aprobacion = id_aprobacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_salida_art != null ? id_salida_art.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salidaarticulo)) {
            return false;
        }
        Salidaarticulo other = (Salidaarticulo) object;
        if ((this.id_salida_art == null && other.id_salida_art != null) || (this.id_salida_art != null && !this.id_salida_art.equals(other.id_salida_art))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.Salidaarticulo[ id_salida_art=" + id_salida_art + " ]";
    }
    
}
