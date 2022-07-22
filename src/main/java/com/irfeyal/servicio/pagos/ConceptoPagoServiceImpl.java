package com.irfeyal.servicio.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irfeyal.interfaces.pagos.IConceptoPagoService;
import com.irfeyal.modelo.dao.pagos.IConceptoPagoDao;
import com.irfeyal.modelo.pagos.ConceptoPago;

@Service
public class ConceptoPagoServiceImpl implements IConceptoPagoService{

	@Autowired
	private IConceptoPagoDao conceptoPagoDao;
	
	@Override
	public List<ConceptoPago> findAll() {
		
		return (List<ConceptoPago>) conceptoPagoDao.findAll();
	}
	
}
