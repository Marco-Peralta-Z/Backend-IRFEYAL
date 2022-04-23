package com.irfeyal.servicio.pagos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irfeyal.interfaces.pagos.ITipoComprobanteService;
import com.irfeyal.modelo.dao.pagos.ITipoComprobanteDao;
import com.irfeyal.modelo.pagos.TipoComprobante;

@Service
public class TipoComprobanteServiceImpl implements ITipoComprobanteService{

	@Autowired
	ITipoComprobanteDao tipoComprobanteDao;

	@Override
	@Transactional(readOnly = true)
	public List<TipoComprobante> findAll() {
		
		return (List<TipoComprobante>) tipoComprobanteDao.findAll();
	}

	@Override
	public Page<TipoComprobante> findAll(Pageable pageable) {
		
		return tipoComprobanteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoComprobante findById(Long id) {
		
		return tipoComprobanteDao.findById(id).orElse(null);
	}

	@Override
	public TipoComprobante save(TipoComprobante tipoComprobante) {
		
		return tipoComprobanteDao.save(tipoComprobante);
	}

	@Override
	public void delete(Long id) {
		tipoComprobanteDao.deleteById(id);
		
	}
	
	

}
