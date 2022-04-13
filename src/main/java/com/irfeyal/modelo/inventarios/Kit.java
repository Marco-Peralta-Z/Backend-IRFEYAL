package com.irfeyal.modelo.inventarios;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "kit")
@NamedQueries({
    @NamedQuery(name = "Kit.findAll", query = "SELECT k FROM Kit k"),
    @NamedQuery(name = "Kit.findByid_kit", query = "SELECT k FROM Kit k WHERE k.id_kit = :id_kit"),
    @NamedQuery(name = "Kit.findByPrecioKit", query = "SELECT k FROM Kit k WHERE k.precioKit = :precioKit"),
    @NamedQuery(name = "Kit.findByPeriodo", query = "SELECT k FROM Kit k WHERE k.periodo = :periodo")})
public class Kit implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_kit")
	private Long id_kit;
    
    @Column(name = "precio_kit")
    private Integer precioKit;
    
    @Column(name = "periodo")
    private String periodo;

    public Kit() {
    }

    public Kit(Long id_kit) {
        this.id_kit = id_kit;
    }

    public Long getid_kit() {
        return id_kit;
    }

    public void setid_kit(Long id_kit) {
        this.id_kit = id_kit;
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
        hash += (id_kit != null ? id_kit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kit)) {
            return false;
        }
        Kit other = (Kit) object;
        if ((this.id_kit == null && other.id_kit != null) || (this.id_kit != null && !this.id_kit.equals(other.id_kit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.irfeyal.mapeoirfeyal.Kit[ id_kit=" + id_kit + " ]";
    }
    
}
