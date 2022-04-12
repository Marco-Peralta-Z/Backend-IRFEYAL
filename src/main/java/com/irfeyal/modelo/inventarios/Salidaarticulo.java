package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "salida_articulo")
public class Salidaarticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salida_art")
    private Long id_salida_art;
    
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    
    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "detallesalida")
    private String detallesalida;
    
    @JoinColumn(name = "id_aprobacion", referencedColumnName = "id_aprobacion")
    @ManyToOne(optional = false)
    private Aprobacion id_aprobacion;

    public Salidaarticulo() {
    }

    public Salidaarticulo(Long id_salida_art) {
        this.id_salida_art = id_salida_art;
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


    public Aprobacion getid_aprobacion() {
        return id_aprobacion;
    }

    public void setid_aprobacion(Aprobacion id_aprobacion) {
        this.id_aprobacion = id_aprobacion;
    }
    
}
