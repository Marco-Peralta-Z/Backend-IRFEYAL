package com.irfeyal.modelo.pagos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "conceptoPago")
@NamedQuery(name = "ConceptoPago.finAll", query="SELECT cp FROM ConceptoPago cp")
public class ConceptoPago {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(columnDefinition = "serial")
	private Long id_conceptoPago;
	private String descripcion;
	
	
	public ConceptoPago() {
		
	}


	public Long getId_conceptoPago() {
		return id_conceptoPago;
	}


	public void setId_conceptoPago(Long id_conceptoPago) {
		this.id_conceptoPago = id_conceptoPago;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

	
	
	
	
}
