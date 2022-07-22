package com.irfeyal.interfaces.pagos;

import java.util.List;

import com.irfeyal.modelo.pagos.ConceptoPago;

public interface IConceptoPagoService {
	
	public List<ConceptoPago> findAll();
	
}
