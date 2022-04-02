package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
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

/**
 *
 * @author Felipe Quichimbo check
 */
@Entity
@Table(name = "modulo_libro")
@NamedQueries({
    @NamedQuery(name = "ModuloLibro.findAll", query = "SELECT m FROM ModuloLibro m"),
    @NamedQuery(name = "ModuloLibro.findByid_modulo_libro", query = "SELECT m FROM ModuloLibro m WHERE m.id_modulo_libro = :id_modulo_libro"),
    @NamedQuery(name = "ModuloLibro.findByCodModulo", query = "SELECT m FROM ModuloLibro m WHERE m.codModulo = :codModulo"),
    @NamedQuery(name = "ModuloLibro.findByNombreModulo", query = "SELECT m FROM ModuloLibro m WHERE m.nombreModulo = :nombreModulo"),
    @NamedQuery(name = "ModuloLibro.findByCurso", query = "SELECT m FROM ModuloLibro m WHERE m.curso = :curso"),
    @NamedQuery(name = "ModuloLibro.findByCantidad", query = "SELECT m FROM ModuloLibro m WHERE m.cantidad = :cantidad"),
    @NamedQuery(name = "ModuloLibro.findByNumero", query = "SELECT m FROM ModuloLibro m WHERE m.numero = :numero"),
    @NamedQuery(name = "ModuloLibro.findByNumeroModulo", query = "SELECT m FROM ModuloLibro m WHERE m.numeroModulo = :numeroModulo")})
public class ModuloLibro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "modulolibro_id")
    private Long id_modulo_libro;
    
    @Basic(optional = false)
    @Column(name = "cod_modulo")
    private int codModulo;
    
    @Column(name = "nombre_modulo")
    private String nombreModulo;
    
    @Column(name = "curso")
    private String curso;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "numero_modulo")
    private String numeroModulo;
    
    @JoinColumn(name = "id_kid", referencedColumnName = "id_kid")
    @ManyToOne(optional = false)
    private Kit id_kid;

    public ModuloLibro() {
    }

    public ModuloLibro(Long id_modulo_libro) {
        this.id_modulo_libro = id_modulo_libro;
    }

    public ModuloLibro(Long id_modulo_libro, int codModulo) {
        this.id_modulo_libro = id_modulo_libro;
        this.codModulo = codModulo;
    }

    public Long getid_modulo_libro() {
        return id_modulo_libro;
    }

    public void setid_modulo_libro(Long id_modulo_libro) {
        this.id_modulo_libro = id_modulo_libro;
    }

    public int getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(int codModulo) {
        this.codModulo = codModulo;
    }

    public String getNombreModulo() {
        return nombreModulo;
    }

    public void setNombreModulo(String nombreModulo) {
        this.nombreModulo = nombreModulo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNumeroModulo() {
        return numeroModulo;
    }

    public void setNumeroModulo(String numeroModulo) {
        this.numeroModulo = numeroModulo;
    }

    public Kit getid_kid() {
        return id_kid;
    }

    public void setid_kid(Kit id_kid) {
        this.id_kid = id_kid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_modulo_libro != null ? id_modulo_libro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModuloLibro)) {
            return false;
        }
        ModuloLibro other = (ModuloLibro) object;
        if ((this.id_modulo_libro == null && other.id_modulo_libro != null) || (this.id_modulo_libro != null && !this.id_modulo_libro.equals(other.id_modulo_libro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.ModuloLibro[ id_modulo_libro=" + id_modulo_libro + " ]";
    }
    
}
