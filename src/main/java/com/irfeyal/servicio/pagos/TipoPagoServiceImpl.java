package com.irfeyal.servicio.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.pagos.ITipoPagoService;
import com.irfeyal.modelo.dao.pagos.ITipoPagoDao;
import com.irfeyal.modelo.pagos.TipoPago;

@Service
public class TipoPagoServiceImpl implements ITipoPagoService{

	@Autowired
	private ITipoPagoDao TipoPagoDao;
	
	@Override
	@Transactional (readOnly= true)
	public List<TipoPago> findAll() {
		
		return (List<TipoPago>) TipoPagoDao.findAll();
	}

	@Override
	@Transactional
	public TipoPago save(TipoPago tipoPago) {

		return TipoPagoDao.save(tipoPago);
	}

	@Override
	@Transactional (readOnly= true)
	public TipoPago findById(Long id) {
		
		return TipoPagoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional 
	public void delete(Long id) {
		
		TipoPagoDao.deleteById(id);
	}

	

}
