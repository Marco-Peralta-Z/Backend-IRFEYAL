/*

package com.irfeyal.modelo.inventarios;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.irfeyal.modelo.rolseguridad.Empleado;


@Entity
@Table(name = "ingreso_kit")
@NamedQueries({
    @NamedQuery(name = "IngresoKit.findAll", query = "SELECT i FROM IngresoKit i"),
    @NamedQuery(name = "IngresoKit.findByid_ingreso_kid", query = "SELECT i FROM IngresoKit i WHERE i.id_ingreso_kid = :id_ingreso_kid"),
    @NamedQuery(name = "IngresoKit.findByFechaIngreso", query = "SELECT i FROM IngresoKit i WHERE i.fechaIngreso = :fechaIngreso")})
public class IngresoKit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso_kid")
    private Long id_ingreso_kid;
    
  
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    
    
    @JoinColumn(name = "id_aprobacion", referencedColumnName = "id_aprobacion")
    @ManyToOne(optional = false)
    private Aprobacion id_aprobacion;
   
    
    @JoinColumn(name = "id_secretaria", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false)
    private Empleado id_secretaria;
    
    
    
    @JoinColumn(name = "id_kit", referencedColumnName = "id_kit")
    @ManyToOne(optional = false)
    private Kit kit;
    
    
    @JoinColumn(name = "id_modulo_libro", referencedColumnName = "id_modulo_libro")
    @ManyToOne(optional = false)
    private ModuloLibro moduloLibro;

    public IngresoKit() {
    }
    
    


	public Long getId_ingreso_kid() {
		return id_ingreso_kid;
	}

	public void setId_ingreso_kid(Long id_ingreso_kid) {
		this.id_ingreso_kid = id_ingreso_kid;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Aprobacion getId_aprobacion() {
		return id_aprobacion;
	}

	public void setId_aprobacion(Aprobacion id_aprobacion) {
		this.id_aprobacion = id_aprobacion;
	}




	public Empleado getId_secretaria() {
		return id_secretaria;
	}



	public void setId_secretaria(Empleado id_secretaria) {
		this.id_secretaria = id_secretaria;
	}




	
	


}
*/