package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.bytebuddy.dynamic.TypeResolutionStrategy.Lazy;

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

    //@OneToMany(mappedBy = "kit", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<ModuloLibro> id_modulo_libro;
    
    //@JoinColumn(name = "id_modulo_libro", referencedColumnName = "id_modulo_libro")
    //@OneToMany(mappedBy = "id_modulo_libro", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<ModuloLibro> id_modulo_libro;
    
    

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_modulo_libro")
    private Set<ModuloLibro> moduloLibro;
    
    
    
    public Kit() {
    }

	public Long getId_kit() {
		return id_kit;
	}

	public void setId_kit(Long id_kit) {
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

	public Set<ModuloLibro> getModuloLibro() {
		return moduloLibro;
	}

	public void setModuloLibro(Set<ModuloLibro> moduloLibro) {
		this.moduloLibro = moduloLibro;
	}





}
